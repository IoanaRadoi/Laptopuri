<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">    
    <xsl:template match="/">
        <html xmlns="http://www.w3.org/1999/xhtml">
            <head>
                <title>TODO supply a title</title>
                <meta name="viewport" content="width=device-width"/>
            </head>    
            <body style="background-color: silver;">
      
                <div style="width: 1000px; height: 300px; margin-left: auto; margin-right: auto; margin-top: 80px; margin-bottom: auto;
align : right; background-image: url('../imagini/poza_laptop2.jpg');">          
                    <div style="margin-left: 450px">
                        <h2>Laptop-uri</h2>
                    </div>
                    <div>
                        <table border="1" style="font-size: 20px; margin-left: 50px; margin-right: 50px;">
                            <tr bgcolor="#F7F1F1">
                                <th style="text-align:left">Marca</th>
                                <th style="text-align:left">Tip</th>
                                <th style="text-align:left">Denumire</th>
                                <th style="text-align:left">Disponibilitate</th>
                                <th style="text-align:left">Frecventa procesor</th>
                                <th style="text-align:left">Diensiune cache procesor</th>
                                <th style="text-align:left">Tip unitate de stocare</th>
                                <th style="text-align:left">Memorie RAM</th>
                                <th style="text-align:left">Capacitate HDD</th>
                                <th style="text-align:left">Pret</th>
                            </tr>                                               
                            <xsl:for-each select="magazin/laptop-uri">                            
                                <xsl:for-each select="producator">                                
                                    <xsl:for-each select="procesor">
                                        <xsl:for-each select="laptop">                                        
                                            <tr>                                            
                                                <td>
                                                    <xsl:value-of select="../../@marca" />
                                                </td>                                            
                                                <td>
                                                    <xsl:value-of select="../@tip"/>
                                                </td>                                            
                                                <td>
                                                    <xsl:value-of select="denumire"/>
                                                </td>                                    
                                                <td>
                                                    <xsl:value-of select="disponibilitate"/>
                                                </td>                                            
                                                <xsl:for-each select="caracteristici/descriere">                                                
                                                    <td>
                                                        <xsl:value-of select="."/>                                               
                                                    </td>                                                                     
                                                </xsl:for-each>                                           
                                            </tr>      
                                        </xsl:for-each>
                                    </xsl:for-each>              
                                </xsl:for-each>
                            </xsl:for-each>                    
                        </table>  
                    </div>  
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

