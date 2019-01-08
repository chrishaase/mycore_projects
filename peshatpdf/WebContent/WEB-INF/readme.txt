PeshatPDF Beta 0.1

1. Abstract: The app creates a PDF from a MyCoRe Peshat xml-Document. 
The app's main-pdf-create servlet runs on 8080/peshatpdf/create. PDF creation is triggered by
an HTTP post-request, sending a mycoreid and a formatid. After receiving the IDs, 
the app loads the peshat document (with the mycoreid) via the MCR-Peshat-Rest api, transforms the xml into 
tex and the tex-file via Mik-Tex into PDF, which is returned. the pdf should display Hebrew.
A landing page for testing runs on 8080/peshatpdf where test-input boxes for the ids can be triggered

2. Configuration
The app needs the following:
-- War deployment on standard Servlet-Container (Tomcat etc.)
-- Access to a working directory on the Server for triggering pdflatex and storing of the docs
-- filepath to working directory in web.xml
-- An installed version of MikTex on the Server with an additional activated! Hebrew-Language-Set
that can be downloaded from https://latex.org/forum/viewtopic.php?t=22173
You will find additional info on that webpage.

3. Current version: Beta 0.1
Basic starting point. The app is in demonstration mode for bibliographical data
Further action needed:
- Implementation of different further xstl-transform sheets for lemmas, quotations etc.
- Implementation of different format-types
- Implementation of error-checking, tests etc. throughout
- Development and integration of app into MyCoRe- Peshat (either as jar-Plugin with classes or as seperate webapp with beans)
- Checking of deployment options (in particular regarding MikTex integration on the server).

app-dev: christian haase (Uni Hamburg)