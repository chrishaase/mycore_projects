PeshatPDF Beta 0.1

1. Overview and Details of Configuration
- The app creates a PDF from a MyCoRe Peshat xml-Document. It is triggered by sending an HTTP post-request with a mycoreId
and a pdfEngine (tex or fop) code to 8080/peshatpdf/create
- The app checks whether it can find the file in the local xmlFilePath (specified in web.xml), if not, the app loads the doc from rest (url in web.xml)
- and saves the xml.file to xmlFilePath (xmlFilePath in web.xml)
- Depending on pdfEngine the app then transforms the xml.file into a tex.file / fo.file  with an xslt transformer (file-config in web.xml)
 - and saves the tex/fo file in the local directory outFilePath (specified in web.xml)
- it then produces a pdf from the tex/fo.file via calling an installed pdfengine via a TexCommandline-Cmd (web.xml config zB xelatex) / or the internal fop-engine
- the following commands are used for tex: pdflatex for a Miktex-install with Babel / xelatex for texlive/xelatex with system-installed fonts
- it returns the pdf via the Web-App.
- he servlet runs on 8080/peshatpdf/create. A landing page for testing runs on 8080/peshatpdf where a test-input box for the id and engine  can be triggered

2. General Server Configuration
The app needs the following:
-- War deployment on standard Servlet-Container (Tomcat etc.)
-- Access to oen or two working directories on the Server for triggering pdflatex and storing of the docs (xmlFilePath and outFilePath)
-- urlPath to mycore-rest api in web.xml
-- An installed version of LiveLatex on the Server with an additional activated! Hebrew-Language-Set
-- For FOP: a folder on the server with hebrew-languages (ttf) -
-- config-file for fop in Web-App Resources (the app loads it down from there and overwrites it)

3. Current version: Beta 0.1
Basic starting point. The app is in demonstration mode for bibliographical data
Further action needed:
- Implementation of different further xstl-transform sheets for lemmas, MCRQuotations etc.
- Implementation of different format-types
- Implementation of error-checking, tests etc. throughout
- Development and integration of app into MyCoRe- Peshat (either as jar-Plugin with classes or as seperate webapp with beans)
- Checking of deployment options (in particular regarding latex integration on the server).
- Decision on pdfEngine (probably not both will be finally installed)

app-dev: christian haase (Uni Hamburg)
