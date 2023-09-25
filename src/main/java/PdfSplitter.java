import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class PdfSplitter {

    public static void main(String[] args) {
        // Input PDF file
        String inputPdfFile = "C:/Users/HP-PC/IdeaProjects/springMVC/input.pdf";

        try {
            // Load the input PDF
            PDDocument document = PDDocument.load(new File(inputPdfFile));

            // Get the total number of pages in the PDF
            int totalPageCount = document.getNumberOfPages();

            // Specify the page range for splitting (e.g., from page 2 to page 4)
            int startPage = 2;
            int endPage = 30;

            // Create a new PDF document for the extracted pages
            PDDocument extractedDocument = new PDDocument();

            // Iterate through the pages and extract the specified range
            for (int i = startPage - 1; i < endPage; i++) {
                PDPage page = document.getPage(i);
                extractedDocument.addPage(page);
            }

            // Save the extracted pages to a new PDF file
            String outputPdfFile = "C:/Users/HP-PC/IdeaProjects/springMVC/output.pdf";
            extractedDocument.save(outputPdfFile);

            // Close the documents
            extractedDocument.close();
            document.close();

            System.out.println("PDF split successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
