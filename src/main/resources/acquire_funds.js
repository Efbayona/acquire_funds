// Selecciona la base
db = db.getSiblingDB('founds');

// Crear usuario con permisos
db.createUser({
    user: "Yorman24",
    pwd: "Profeta2",
    roles: [ { role: "readWrite", db: "founds" } ]
});

//insertar datos en la colección acquire_funds
db.acquire_funds.insertMany([
    {
        acquireFundsId: 1,
        name: "FPV_BTG_PACTUAL_RECAUDADORA",
        minimumAmount: 75.000,
        category: "FPV"
    },
    {
        acquireFundsId: 2,
        name: "FPV_BTG_PACTUAL_ECOPETROL",
        minimumAmount: 125.000,
        category: "FPV"
    },
    {
        acquireFundsId: 3,
        name: "DEUDAPRIVADA",
        minimumAmount: 50.000,
        category: "FIC"
    },
    {
        acquireFundsId: 4,
        name: "FDO-ACCIONES",
        minimumAmount: 250.000,
        category: "FIC"
    },
    {
        acquireFundsId: 5,
        name: "FPV_BTG_PACTUAL_DINAMICA",
        minimumAmount: 100.000,
        category: "FPV"
    }
]);