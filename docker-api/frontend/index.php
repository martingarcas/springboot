<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="listado-productos">
        <?php
            // Configuración de la API
            $url = 'http://backend:9000/api/products';

            // Hacer la solicitud GET a la API
            $response = file_get_contents($url);

            if ($response === FALSE) {
                echo '<p style="color: red;">Hubo un error al cargar los datos.</p>';
            } else {
                $productos = json_decode($response, true);

                if (count($productos) > 0) {
                    // Crear la tabla
                    echo '<table>';
                    echo '<thead>';
                    echo '<tr>';
                    echo '<th>ID</th>';
                    echo '<th>Title</th>';
                    echo '<th>Price</th>';
                    echo '<th>Quantity</th>';
                    echo '</tr>';
                    echo '</thead>';
                    echo '<tbody>';

                    // Recorrer los productos y mostrar cada uno en una fila
                    foreach ($productos as $producto) {
                        echo '<tr>';
                        echo '<td>' . htmlspecialchars($producto['id']) . '</td>';
                        echo '<td>' . htmlspecialchars($producto['title']) . '</td>';
                        echo '<td>' . htmlspecialchars($producto['price']) . '</td>';
                        echo '<td>' . htmlspecialchars($producto['quantity']) . '</td>';
                        echo '</tr>';
                    }

                    echo '</tbody>';
                    echo '</table>';
                } else {
                    echo '<p>No se encontraron productos.</p>';
                }
            }
        ?>
    </div>

</body>
</html>
