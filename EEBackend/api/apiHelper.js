const mysql = require("mysql2");

const con = mysql.createConnection({
    host: "127.0.0.1",
    user: "root",
    database: "schema",
    password: "1234"
  });

module.exports = con;