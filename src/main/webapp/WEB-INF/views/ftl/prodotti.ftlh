<!DOCTYPE html>
<html>
    <head>
        <title>Cities</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       
        </head>
    <body>
        <h2>List of Prodotti</h2>

        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Identificativo</th>
                <th>descrizione</th>
                <th>prezzo</th>
            </tr>

            <#list prodotti as prodotto>
                <tr>
                    <td>${prodotto.id}</td>
                    <td>${prodotto.nome}</td>
                    <td>${prodotto.identificativo}</td>
                    <td>${prodotto.descrizione}</td>
                    <td>${prodotto.prezzo}</td>
                </tr>
            </#list>
        </table>

    </body>
</html>
