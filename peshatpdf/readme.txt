PeshatPDF Beta 0.1

1. Abstract: 
- The app creates a PDF from a MyCoRe Peshat xml-Document. 
- The servlet runs on 8080/peshatpdf/create. 
- you need to send an HTTP post-request with a mycoreid
- After receiving the IDs, the app checks whether is can find the file in the local xmlfilepath (specified in web.xml)
- if not, the app loads the peshat document from the MCR-Peshat-Rest api (url specified in web.xml)
- saves the xml.file to xmlfilepath 
- then transforms the xml.file into a tex.file  with an xslt transformer
- and save the tex file in the local directory outfilepath (specified in web.xml)
- it then produces a pdf from the tex.file via calling mixktex pdflatex in the local directory outfilepath
- it returns the pdf
- A landing page for testing runs on 8080/peshatpdf where a test-input box for the id  can be triggered

2. Configuration
The app needs the following:
-- War deployment on standard Servlet-Container (Tomcat etc.)
-- Access to oen or two working directories on the Server for triggering pdflatex and storing of the docs (xmlfilepath and outfilepath)
-- urlpath to mycore-rest api in web.xml
-- An installed version of LiveLatex on the Server with an additional activated! Hebrew-Language-Set

3. Current version: Beta 0.1
Basic starting point. The app is in demonstration mode for bibliographical data
Further action needed:
- Implementation of different further xstl-transform sheets for lemmas, quotations etc.
- Implementation of different format-types
- Implementation of error-checking, tests etc. throughout
- Development and integration of app into MyCoRe- Peshat (either as jar-Plugin with classes or as seperate webapp with beans)
- Checking of deployment options (in particular regarding latex integration on the server).

app-dev: christian haase (Uni Hamburg)
