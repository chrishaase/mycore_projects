PeshatPDF Beta 0.1

1. Overview and Details of Configuration
- The app creates a PDF from a MyCoRe Peshat xml-Document. It is triggered by sending an HTTP post-request with a mycoreId to 8080/peshatpdf/create
- The app checks whether is can find the file in the local xmlFilePath (specified in web.xml), if not, the app loads the doc from rest (url in web.xml)
- and saves the xml.file to xmlFilePath (xmlFilePath in web.xml)
- Depending on configuration (current impl via tex): the app then transforms the xml.file into a tex.file  with an xslt transformer (file in web.xml)
 - and saves the tex file in the local directory outFilePath (specified in web.xml)
- it then produces a pdf from the tex.file via calling an installed pdfengine via a TexCommandline-Cmd (web.xml)
- the following commands are used: pdflatex for a Miktex-install with Babel / xelatex for texlive/xelatex with system-installed fonts
- it returns the pdf via the Web-App.
- he servlet runs on 8080/peshatpdf/create. A landing page for testing runs on 8080/peshatpdf where a test-input box for the id  can be triggered

2. General Server Configuration
The app needs the following:
-- War deployment on standard Servlet-Container (Tomcat etc.)
-- Access to oen or two working directories on the Server for triggering pdflatex and storing of the docs (xmlFilePath and outFilePath)
-- urlPath to mycore-rest api in web.xml
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
