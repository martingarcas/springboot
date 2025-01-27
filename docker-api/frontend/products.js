document.addEventListener('DOMContentLoaded', function () {
   
    let productosCnt = document.querySelector('.listado-productos');
    
    async function solicitudApi() {

        try {
            const response = await fetch('http://localhost:9000/api/products', { method: 'GET'});
            const data = await response.json();

            let productos = data;  // Ahora 'data' es directamente el array de productos
            // Crear una tabla
            let tabla = document.createElement('table');
            tabla.style.borderCollapse = 'collapse';
            tabla.style.width = '100%';
            tabla.style.margin = '20px 0';

            // Crear cabeceras de la tabla
            let cabecera = document.createElement('thead');
            cabecera.innerHTML = `
                <tr>
                    <th style="border: 1px solid #ccc; padding: 8px;">ID</th>
                    <th style="border: 1px solid #ccc; padding: 8px;">Title</th>
                    <th style="border: 1px solid #ccc; padding: 8px;">Price</th>
                    <th style="border: 1px solid #ccc; padding: 8px;">Quantity</th>
                </tr>
            `;
            tabla.appendChild(cabecera);

            // Crear cuerpo de la tabla
            let cuerpo = document.createElement('tbody');

            productos.forEach(producto => {
                let fila = document.createElement('tr');
                fila.innerHTML = `
                    <td style="border: 1px solid #ccc; padding: 8px; text-align: center;">${producto.id}</td>
                    <td style="border: 1px solid #ccc; padding: 8px; text-align: center;">${producto.title}</td>
                    <td style="border: 1px solid #ccc; padding: 8px; text-align: center;">${producto.price}</td>
                    <td style="border: 1px solid #ccc; padding: 8px; text-align: center;">${producto.quantity}</td>
                `;
                cuerpo.appendChild(fila);
            });

            tabla.appendChild(cuerpo);

            // Agregar la tabla al contenedor
            productosCnt.appendChild(tabla);

        } catch (error) {
            console.error('Error:', error);
            productosCnt.innerHTML = `<p style="color: red;">Hubo un error al cargar los datos.</p>`;
        }
    }

    solicitudApi();
});
