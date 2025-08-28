# Proyecto Spring con MongoDB

Este proyecto utiliza Spring Boot y MongoDB para gestionar usuarios, transacciones y fondos de inversión. La base de datos se ejecuta en un contenedor Docker para facilitar el desarrollo y las pruebas locales.

---

#  1.Levantar la base de datos con Docker

---

Ubica el archivo docker-compose.yml en la raíz del proyecto y levanta los servicios:


#  2.Corre los siguientes comandos

---
- docker exec -it founds-db mongosh -u edwin -p 123456
- use founds-db

# 3.Crear las colecciones 
- db.createCollection("users");
- db.createCollection("transactions");
- db.createCollection("acquire_funds");

## Poblar la base

db.acquire_funds.insertMany([
{
acquireFundsId: 1,
name: "FPV_BTG_PACTUAL_RECAUDADORA",
minimumAmount: 75000,
category: "FPV"
},
{
acquireFundsId: 2,
name: "FPV_BTG_PACTUAL_ECOPETROL",
minimumAmount: 125000,
category: "FPV"
},
{
acquireFundsId: 3,
name: "DEUDAPRIVADA",
minimumAmount: 50000,
category: "FIC"
},
{
acquireFundsId: 4,
name: "FDO-ACCIONES",
minimumAmount: 250000,
category: "FIC"
},
{
acquireFundsId: 5,
name: "FPV_BTG_PACTUAL_DINAMICA",
minimumAmount: 100000,
category: "FPV"
}
]);

## Correr el proyecto.