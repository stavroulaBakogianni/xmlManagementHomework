<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  
  <!-- Root template to match the catalog element -->
  <xsl:template match="/catalog">
    <html>
      <body>
        <h2>Book Catalog</h2>
        <table border="1">
          <tr>
            <th>Author</th>
            <th>Title</th>
            <th>Price</th>
          </tr>
          
          <!-- Apply template for each book element -->
          <xsl:for-each select="book">
            <tr>
              <td><xsl:value-of select="author"/></td>
              <td><xsl:value-of select="title"/></td>
              <td><xsl:value-of select="price"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>