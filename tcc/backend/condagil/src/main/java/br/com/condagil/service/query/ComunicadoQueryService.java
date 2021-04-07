package br.com.condagil.service.query;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.builder.ComunicadoDTOBuilder;
import br.com.condagil.models.dto.ComunicadoDTO;
import br.com.condagil.repository.query.ComunicadoQueryRepository;

@Service
public class ComunicadoQueryService {

	@Autowired
	private ComunicadoQueryRepository comunicadoQueryRepository;
	
	public List<ComunicadoDTO> recuperarComunicados(){
		List<ComunicadoDTO> listaComunicadosDto = ComunicadoDTOBuilder
				.converterListaEntityEmComunicadoDTO(comunicadoQueryRepository.recuperarComunicados());
		return listaComunicadosDto;
	}

	public ComunicadoDTO recuperarComunicadoPorId(Long comunicadoId) {
		return ComunicadoDTOBuilder.getInstance()
				.converterEntityEmComunicadoDTO(comunicadoQueryRepository.recuperarComunicadoPorId(comunicadoId))
				.getComunicadoDTO();
	}

	public ByteArrayInputStream exportarComunicadoPdf(Long comunicadoId) throws ResourceNotFoundException{
		ComunicadoDTO comunicadoDTO = recuperarComunicadoPorId(comunicadoId);
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document, out);
			document.open();
			
			com.itextpdf.text.Font fontHeader = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK);
			Paragraph paragraphTitulo = new Paragraph("Comunicado" , fontHeader);
			paragraphTitulo.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraphTitulo);
			document.add(Chunk.NEWLINE);
			
			com.itextpdf.text.Font fontDescricao = FontFactory.getFont(FontFactory.COURIER_BOLD, 14);
			Paragraph paragraphConteudo = new Paragraph(comunicadoDTO.getTexto() , fontDescricao);
			paragraphConteudo.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraphConteudo);
			document.add(Chunk.NEWLINE);
			
			com.itextpdf.text.Font fontFooter = FontFactory.getFont(FontFactory.COURIER, 14);
			Paragraph paragraphFooter = new Paragraph("Este comunicado é válido até "+comunicadoDTO.getDataValidadeStr() , fontFooter);
			paragraphFooter.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraphFooter);
			
			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	}
}