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

import br.com.condagil.models.builder.DespesaDTOBuilder;
import br.com.condagil.models.dto.DespesaDTO;
import br.com.condagil.repository.query.DespesaQueryRepository;

@Service
public class DespesaQueryService {

	@Autowired
	private DespesaQueryRepository despesaQueryRepository;
	
	public List<DespesaDTO> recuperarDespesas(){
		List<DespesaDTO> listaDespesasDto = DespesaDTOBuilder
				.converterListaEntityEmDespesaDTO(despesaQueryRepository.recuperarDespesas());
		return listaDespesasDto;
	}

	public DespesaDTO recuperarDespesaPorId(Long DespesaId) {
		return DespesaDTOBuilder.getInstance()
				.converterEntityEmDespesaDTO(despesaQueryRepository.recuperarDespesaPorId(DespesaId))
				.getDespesaDTO();
	}
	
	public ByteArrayInputStream exportarDespesasPdf() {
		List<DespesaDTO> listaDespesasDto = recuperarDespesas();
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document, out);
			document.open();
			com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
			Paragraph paragraph = new Paragraph("Lista de Despesas" , font);
			document.add(paragraph);
			document.add(Chunk.NEWLINE);
			PdfPTable pdfPTable = new PdfPTable(3);
			Stream.of("Descrição","Data", "Valor").forEach(headerTitle->{
				PdfPCell header = new PdfPCell();
				com.itextpdf.text.Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(headerTitle, headFont));
				pdfPTable.addCell(header);
			});
			for(DespesaDTO dto: listaDespesasDto) {
				PdfPCell descricaoCell = new PdfPCell(new Phrase(dto.getDescricao()));
				descricaoCell.setPaddingLeft(1);
				descricaoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				descricaoCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pdfPTable.addCell(descricaoCell);
				
				PdfPCell dataCell = new PdfPCell(new Phrase(dto.getDataDespesaStr()));
				dataCell.setPaddingLeft(1);
				dataCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				dataCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pdfPTable.addCell(dataCell);
				
				PdfPCell valorCell = new PdfPCell(new Phrase(dto.getValor().toString()));
				valorCell.setPaddingLeft(1);
				valorCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				valorCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				pdfPTable.addCell(valorCell);
			}
			document.add(pdfPTable);
			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());
	}
}
