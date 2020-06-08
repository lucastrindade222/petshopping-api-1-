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
import com.petshopping.repositores.ProdutoRepositores;
import com.petshopping.service.Exception.FileException;
import com.petshopping.service.Exception.ObejectNotFoudException;;

@Service
public class ProdutoService {

	@Value("${s3.bucket}")
	private String bucket;

	@Autowired
	private ProdutoRepositores repo;
	
	@Autowired
	private AmazonS3 amazonS3;

	public List<Produtos> listarproduto() {
		return repo.findAll();
	}

	public Produtos buscar(Integer id) {
		Optional<Produtos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObejectNotFoudException("Serviso não encontrado. Id: " + id));
	}

	public Produtos save(Produtos produto) {
		return repo.save(produto);
	}

	public Produtos update(Produtos produto) {
		return repo.save(produto);
	}

	public void deletByid(Integer id) {
		repo.deleteById(id);
	}

	public URI uploadFoto(Integer id, MultipartFile multipartFile) {

		try {
			String ext = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

			if (!ext.equals("png") && !ext.equals("jpg")) {
				throw new FileException("ERRO:o arquivo informado não a exteção .png ou .jpg");
			}
			Produtos produtos = buscar(id);
			String nomeArquivo = "serviso" + id + "." + ext;
			String contentType = multipartFile.getContentType();
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			amazonS3.putObject(bucket, "serviso/" + nomeArquivo, multipartFile.getInputStream(), meta);

			produtos.setNomefoto(nomeArquivo);
			repo.save(produtos);
			return amazonS3.getUrl(bucket, "serviso/" + nomeArquivo).toURI();

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
