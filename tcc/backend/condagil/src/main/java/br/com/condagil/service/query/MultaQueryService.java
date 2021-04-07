package br.com.condagil.service.query;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.builder.MultaDTOBuilder;
import br.com.condagil.models.dto.MultaDTO;
import br.com.condagil.repository.query.MultaQueryRepository;

@Service
public class MultaQueryService {

	@Autowired
	private MultaQueryRepository multaQueryRepository;
	
	public List<MultaDTO> recuperarMultas(){
		List<MultaDTO> listaMultasDto = MultaDTOBuilder
				.converterListaEntityEmMultaDTO(multaQueryRepository.recuperarMultas());
		return listaMultasDto;
	}

	public MultaDTO recuperarMultaPorId(Long multaId) {
		return MultaDTOBuilder.getInstance()
				.converterEntityEmMultaDTO(multaQueryRepository.recuperarMultaPorId(multaId))
				.getMultaDTO();
	}
	
	public ByteArrayInputStream exportarMultaPdf(Long multaId) throws ResourceNotFoundException{
		MultaDTO dto = recuperarMultaPorId(multaId);
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document, out);
			document.open();
			
			com.itextpdf.text.Font fontHeader = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK);
			Paragraph paragraphTitulo = new Paragraph("Multa" , fontHeader);
			paragraphTitulo.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraphTitulo);
			document.add(Chunk.NEWLINE);
			PdfPTable pdfPTable = new PdfPTable(2);
			
			Stream.of("").forEach(headerTitle->{
				PdfPCell header = new PdfPCell();
				com.itextpdf.text.Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(headerTitle, headFont));
				pdfPTable.addCell(header);
			});
			
			PdfPCell moradorCell = new PdfPCell(new Phrase("Morador : "+dto.getMorador().getNome()));
			moradorCell.setPaddingLeft(1);
			moradorCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			moradorCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			pdfPTable.addCell(moradorCell);
			
			PdfPCell motivoCell = new PdfPCell(new Phrase("Motivo : "+dto.getMotivo()));
			motivoCell.setPaddingLeft(1);
			motivoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			motivoCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			pdfPTable.addCell(motivoCell);
			
			PdfPCell dataOcorrenciaCell = new PdfPCell(new Phrase("Data : "+dto.getDataOcorrencia()));
			dataOcorrenciaCell.setPaddingLeft(1);
			dataOcorrenciaCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			dataOcorrenciaCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			pdfPTable.addCell(dataOcorrenciaCell);
			
			PdfPCell valorCell = new PdfPCell(new Phrase("Valor : "+dto.getValor()));
			valorCell.setPaddingLeft(1);
			valorCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			valorCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			pdfPTable.addCell(valorCell);
			
			document.add(pdfPTable);
			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	}
	
	
}
