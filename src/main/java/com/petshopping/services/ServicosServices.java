package com.petshopping.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.petshopping.domain.Produtos;
import com.petshopping.domain.Servicos;
import com.petshopping.repositores.ServicoRepositores;
import com.petshopping.service.Exception.FileException;
import com.petshopping.service.Exception.ObejectNotFoudException;

@Service
public class ServicosServices {

	
	
	
	@Value("${s3.bucket}")
	private String bucket;
	
	@Autowired
	private AmazonS3 amazonS3;
	
	
	@Autowired
	public ServicoRepositores repo;

	public List<Servicos> listarservico() {
		return repo.findAll();
	}

	public Servicos buscar(Integer id) {
		Optional<Servicos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObejectNotFoudException( "Serviço não encontrado. Id: "+id));
	}

	public Servicos salve(Servicos servicos) {
		return repo.save(servicos);
	}
	public Servicos update(Servicos servicos) {
		return repo.save(servicos);
	}
	
	public void deletbyid(Integer id) {
		repo.deleteById(id);
	}
	
	public URI uploadFoto(Integer id, MultipartFile multipartFile) {

		try {
			String ext = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

			if (!ext.equals("png") && !ext.equals("jpg")) {
				throw new FileException("ERRO:o arquivo informado não a exteção .png ou .jpg");
			}
			Integer inx=listarservico().size();;
			System.out.println(""+inx);
			 System.out.println("id foto servico:"+id);
			 id=  1+inx;
			 System.out.println("id foto servico:"+id);
			
			 
			 Servicos servicos= buscar(id);
			String nomeArquivo = "servicos" + id + "." + ext;
			String contentType = multipartFile.getContentType();
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			amazonS3.putObject(bucket, "servicos/" + nomeArquivo, multipartFile.getInputStream(), meta);

			servicos.setNomefoto(nomeArquivo);
			
			repo.save(servicos);
			
			return amazonS3.getUrl(bucket, "servicos/" + nomeArquivo).toURI();

		} catch (AmazonServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SdkClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
