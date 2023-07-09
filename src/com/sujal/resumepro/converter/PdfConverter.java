package com.sujal.resumepro.converter;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PdfConverter {
	public static void run() {
		// Create a new document
		Document document = new Document();

		try {
			// Set the output file path
			String outputPath = "D:\\Projects\\Java\\ResumePro\\bin\\resume.pdf";

			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF files (*.pdf)", "pdf");
			fileChooser.setFileFilter(filter);
			int rs = fileChooser.showSaveDialog(null);
			if (rs == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				String selectedFilePath = selectedFile.getPath();

				// Make sure the selected file has a .pdf extension
				if (!selectedFilePath.toLowerCase().endsWith(".pdf")) {
					selectedFilePath += ".pdf";
				}

				outputPath = selectedFilePath;

			}

			// Create a PdfWriter instance to write the document to a file
			PdfWriter.getInstance(document, new FileOutputStream(outputPath));

			// Open the document
			document.open();

			// Add the collected data to the document
			addCollectedData(document);

			// Close the document
			document.close();

			System.out.println("PDF created successfully at " + outputPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addCollectedData(Document document) throws DocumentException {
		// Create a font for the resume headings
		Font headingFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Font.UNDERLINE);

		// Add the collected data to the document
		document.add(new Paragraph("Name: " + CollectedData.name, headingFont));
		if (!CollectedData.address.isEmpty())
			document.add(new Paragraph("Address: " + CollectedData.address));
		if (!CollectedData.phone.isEmpty())
			document.add(new Paragraph("Phone: " + CollectedData.phone));
		if (!CollectedData.email.isEmpty())
			document.add(new Paragraph("Email: " + CollectedData.email));
		if (!CollectedData.website.isEmpty())
			document.add(new Paragraph("Website: " + CollectedData.website));

		document.add(Chunk.NEWLINE);

		document.add(new Paragraph("Education:", headingFont));
		for (EducationData educationData : CollectedData.educationDatas) {
			document.add(new Paragraph("Institute Name: " + educationData.instituteName(), headingFont));
			if (!educationData.from().isEmpty())
				document.add(new Paragraph("From: " + educationData.from()));
			if (!educationData.to().isEmpty())
				document.add(new Paragraph("To: " + educationData.to()));
			if (!educationData.certificate().isEmpty())
				document.add(new Paragraph("Certificate: " + educationData.certificate()));
			document.add(Chunk.NEWLINE);
		}

		document.add(new Paragraph("Skills:", headingFont));
		for (String skill : CollectedData.skills) {
			document.add(new Paragraph(skill));
		}

		document.add(new Paragraph("Experience:", headingFont));
		for (ExperienceData experienceData : CollectedData.experienceDatas) {
			document.add(new Paragraph("Institute: " + experienceData.institute(), headingFont));
			if (!experienceData.from().isEmpty())
				document.add(new Paragraph("From: " + experienceData.from()));
			if (!experienceData.to().isEmpty())
				document.add(new Paragraph("To: " + experienceData.to()));
			if (!experienceData.designation().isEmpty())
				document.add(new Paragraph("Designation: " + experienceData.designation()));
			document.add(Chunk.NEWLINE);
		}
	}
}
