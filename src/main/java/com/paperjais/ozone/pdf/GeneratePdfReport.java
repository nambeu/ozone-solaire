package com.paperjais.ozone.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.paperjais.ozone.entity.ClientDTO;
import com.paperjais.ozone.entity.Equipement;
import com.paperjais.ozone.entity.Facture;
import com.paperjais.ozone.entity.FeuilleCalcul;

public class GeneratePdfReport {

	public static final Font policeParagraph = new Font(FontFamily.TIMES_ROMAN,
			24, Font.BOLDITALIC);

	public static final Font police1 = new Font(FontFamily.TIMES_ROMAN, 18,
			Font.BOLDITALIC);

	public static final Font headFont = new Font(FontFamily.HELVETICA, 12,
			Font.BOLD);

	public static ByteArrayInputStream factureReport(
			List<Equipement> listeEquipement, Facture facture,
			ClientDTO client, FeuilleCalcul feuille) throws IOException {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			BaseFont lato = BaseFont.createFont(
					"src/main/resources/static/fonts/Lato-Black.ttf",
					BaseFont.WINANSI, true);
			BaseFont obelix = BaseFont.createFont(
					"src/main/resources/static/fonts/ObelixPro-Broken-cyr.ttf",
					BaseFont.WINANSI, true);
			BaseFont bethanie = BaseFont.createFont(
					"src/main/resources/static/fonts/Bethanie Snake_PersonalUseOnly.ttf",
					BaseFont.WINANSI, true);
            
			Font obe = new Font(obelix, 24, Font.BOLD);
			Font bet = new Font(lato, 14, Font.BOLD);
			Font lat = new Font(lato, 12);
			Font latitalic = new Font(lato, 14, Font.NORMAL);
			Font latBold = new Font(lato, 14, Font.BOLD);

			// premiere tableau pour les articles de la facture
			PdfPTable table = new PdfPTable(6);
			table.setTotalWidth(550);
			table.setLockedWidth(true);
			// table.setWidths(new int[] { 1, 2, 2, 1, 1, 3 });

			PdfPCell hcell;

			hcell = new PdfPCell(new Phrase("Reference", lat));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setVerticalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			hcell.setFixedHeight(20f);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Désignation", lat));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Technique", lat));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Quantité", lat));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Prix Unitaire", lat));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Montant HT", lat));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(hcell);

			for (int i = 0; i < listeEquipement.size(); i++) {
				Long a = (long) (i + 1);
				PdfPCell cell;

				cell = new PdfPCell(new Phrase(a.toString()));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(listeEquipement.get(i)
						.getDesignation()));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(listeEquipement.get(i)
						.getTechnique()));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(new Long(listeEquipement.get(i)
						.getQuantite()).toString()));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(new Long(listeEquipement.get(i)
						.getPrixUnitaire()).toString()));
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(new Long(listeEquipement.get(i)
						.getMontantHt()).toString()));
				table.addCell(cell);
			}
			// fin du tableau
			hcell = new PdfPCell(new Phrase("MONTANT TOTAL HT", latBold));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			// hcell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			hcell.setColspan(3);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase(
					new Long(facture.getMontantTotal()).toString()));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setColspan(3);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("TVA (19,25% )", latBold));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setColspan(3);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase(
					new Long(facture.getTaxe()).toString()));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setColspan(3);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("MONTANT TTC", latBold));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setColspan(3);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase(
					new Long(facture.getMontantTTC()).toString()));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setColspan(3);
			table.addCell(hcell);

			/*
			 * image d'acceuil ou entête
			 * 
			 * Image image =
			 * Image.getInstance("src/main/resources/static/image/Clear.jpg");
			 * image.scaleToFit(800, 200);
			 */

			// paragraph de parametre client du proformat...
			Paragraph paramClient = new Paragraph();
			paramClient.add(new Phrase(client.getLastName(), latitalic));
			paramClient.add(Chunk.NEWLINE);
			paramClient.add(new Phrase(client.getFirstName(), latitalic));
			paramClient.add(Chunk.NEWLINE);
			paramClient.add(new Phrase(client.getEmail(), latitalic));
			paramClient.add(Chunk.NEWLINE);
			paramClient.add(new Phrase(client.getAddress(), latitalic));
			paramClient.add(Chunk.NEWLINE);
			paramClient.add(new Phrase(client.getTelephone(), latitalic));
			paramClient.setAlignment(Element.ALIGN_JUSTIFIED);
			paramClient.setIndentationLeft(50);

			// paragraph parametre sur l'entreprise
			Paragraph fournisseur = new Paragraph();
			fournisseur.add(new Phrase("NAMBEZ SOFTECH SARL", latBold));
			fournisseur.add(Chunk.NEWLINE);
			fournisseur.add(new Phrase("Bonaberi, Douala", latBold));
			fournisseur.add(Chunk.NEWLINE);
			fournisseur.add(new Phrase("(+237) XXX XXX XXX / XXX XXX XXX ", latBold));
			fournisseur.setAlignment(Element.ALIGN_LEFT);

			// paragraph parametre sur la date de creation de la facture
			Paragraph date = new Paragraph();
			date.add(new Phrase("Douala, le " + new Date(), latitalic));
			date.setAlignment(Element.ALIGN_RIGHT);

			// paragraph parametre de l'entete de la facture
			Paragraph entete = new Paragraph();
			entete.add(new Phrase("FACTURE", obe));
			entete.setAlignment(Element.ALIGN_CENTER);

			// paragraph parametre des conditions
			Paragraph paragraphFooter = new Paragraph();
			Phrase phrase;

			phrase = new Phrase();
			phrase.add(new Chunk("Condition de Paiement :" , latBold));
			phrase.add(new Chunk("100 % à la Commande", latitalic));
			paragraphFooter.add(phrase);
			paragraphFooter.add(Chunk.NEWLINE);

			phrase = new Phrase();
			phrase.add(new Chunk("NB : ", latBold));
			phrase.add(new Chunk(
					"Service après vente assuré durant toute la période du Contrat", latitalic));
			paragraphFooter.add(phrase);
			paragraphFooter.add(Chunk.NEWLINE);

			paragraphFooter.setPaddingTop(30);
			paragraphFooter.setAlignment(Element.ALIGN_JUSTIFIED);
			paragraphFooter.setIndentationLeft(35);

			// paragraph de objet du proformat...
			Paragraph objet = new Paragraph();
			String texte = "OBJET ", texte2 = ":  Installation d'un système électrique par energie solaire 1407WC pour une énergie de 4.56 Kwh par jour pendant la periode de forte pluie par "
					+ feuille.getNbreJourAutonomie() + " jours d'autonomie";
			objet.add(new Phrase(texte, latBold));
			objet.add(new Phrase(texte2, latitalic));
			objet.setAlignment(Element.ALIGN_JUSTIFIED);
			objet.setIndentationLeft(35);

			PdfWriter.getInstance(document, out);
			document.open();

			document.add(entete);
			document.add(Chunk.NEWLINE);
			document.add(fournisseur);
			document.add(Chunk.NEWLINE);
			document.add(date);
			document.add(Chunk.NEWLINE);
			document.add(paramClient);
			document.add(Chunk.NEWLINE);
			document.add(objet);
			document.add(Chunk.NEWLINE);
			document.add(table);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(paragraphFooter);

			// 

			document.close();

		} catch (DocumentException ex) {

			// Logger.getLogger(GeneratePdfReport.class.getName()).log(Leve)
		}

		return new ByteArrayInputStream(out.toByteArray());
	}
}
