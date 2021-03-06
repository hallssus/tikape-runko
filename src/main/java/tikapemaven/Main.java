package tikapemaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.Session;
import static spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import tikape.database.Database;
import tikape.database.ViestiDao;
import tikape.database.AiheDao;
import tikape.database.AlueDao;
import tikape.pojo.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
//        Connection connection = DriverManager.getConnection("jdbc:sqlite:Keskustelupalsta.db");
        
//        Statement statement = connection.createStatement();

//        ResultSet resultSet = statement.executeQuery("SELECT 1");
//
//        if(resultSet.next()) {
//            System.out.println("Hei tietokantamaailma!");
//        } else {
//            System.out.println("Yhteyden muodostaminen epäonnistui.");
//        }
//        
        Database database = new Database("org.sqlite.JDBC", "jdbc:sqlite:Keskustelupalsta.db");
        database.setDebugMode(true);

        AiheDao aiheDao = new AiheDao(database);
        ViestiDao viestiDao = new ViestiDao(database);
        AlueDao alueDao = new AlueDao(database);
        for(Alue alue: alueDao.findAll()){
            System.out.println(alue.getNimi());
            System.out.println(alue.getLuomispaiva());
            System.out.println(alue.getViimeisinViesti());
        }

//        post("/s/tsats", (req, res) -> {
//            HashMap map = new HashMap<>();
//            Alue mikaAlue = (Alue) req.session().attribute("alue");
//            String text = "";
//            
//            if (req.queryParams().contains("message")) {
//                text = req.queryParams("message");
//            }
//            ViestiDao.save(new Viesti(text, ));
//            // TODO: add a new chat message
//            // see from "tsats.html" to figure out what the parameters
//            // are called
//            
//            res.redirect("/s/users/" + loggedUser.getId());
//            return "";
//        });
//        
        
        List<String> list = new ArrayList<>();
        

        get("/", (req, res) -> {
            HashMap map = new HashMap<>();
            
            map.put("alueet", alueDao.findAll());
                   
            
            return new ModelAndView(map, "index");
        }, new ThymeleafTemplateEngine());

        post("/", (req, res) -> {

            alueDao.save(new Alue(req.queryParams("nimi"),"tänään"));
            res.redirect("/");
            return "onnistui";
        });
        
        
        
        get("/:a_nimi", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("aiheet", aiheDao.etsiKaikkiAlueenNimella(req.params(":a_id")));
            return new ModelAndView(map, "aihe");
        }, new ThymeleafTemplateEngine());

        post("/:a.nimi", (req, res) -> {

            aiheDao.lisaaAihe(req.queryParams("nimi"),"tänään",req.params(":a"));
            res.redirect("/:a_nimi");
            return "onnistui taas";
        });

    }
}
