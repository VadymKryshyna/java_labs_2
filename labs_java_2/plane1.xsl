<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="//plane">
        <html>
            <head>
                <title>Plane transformation</title>
		<style type="text/css">
                    .title{
                    color:#1E0FBE;
                    cursor:pointer;
                    font-weight: bold;
                    font-family: Lucida Console;
                    }
                    .title1{
                    color:#FF0FBE;
                    cursor:pointer;
                    font-weight: bold;
                    font-family: Lucida Console;
                    }
		</style>
            </head>
            <body>
                <div class="title">Model</div>
                <div class="value"><xsl:value-of select="model"/></div>
                <div class="title">Origin</div>
                <div class="value"><xsl:value-of select="origin"/></div>
                <div class="title">Chars</div>
                <div class="title1">ID</div>
                <div class="value1"><xsl:value-of select="chars/@id"/></div>
                <div class="title1">Type</div>
                <div class="value1"><xsl:value-of select="chars/type"/></div>
                <div class="title1">Seat</div>
                <div class="value1"><xsl:value-of select="chars/seat"/></div>
                <div class="title1">Arming</div>
                <div class="value1"><xsl:value-of select="chars/arming"/></div>
                <div class="title1">Rockets</div>
                <div class="value1"><xsl:value-of select="chars/rockets"/></div>
                <div class="title1">Radar</div>
                <div class="value1"><xsl:value-of select="chars/radar"/></div>
                <div class="title">Parameters</div>
                <div class="title1">Length</div>
                <div class="value1"><xsl:value-of select="parameters/length"/></div>
                <div class="title1">Height</div>
                <div class="value1"><xsl:value-of select="parameters/height"/></div>
                <div class="title1">Width</div>
                <div class="value1"><xsl:value-of select="parameters/width"/></div>
                <div class="title">Price</div>
                <div class="value"><xsl:value-of select="price"/></div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>