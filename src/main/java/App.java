import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    ProcessBuilder process = new ProcessBuilder();
         Integer port;
         if (process.environment().get("PORT") != null) {
             port = Integer.parseInt(process.environment().get("PORT"));
         } else {
             port = 4567;
         }

        setPort(port);
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";


get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      // model.put("squads", Squad.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cobras/new", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/cobra-form.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/cobras", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          String name = request.queryParams("name");
          String power = request.queryParams("power");
          int age = Integer.parseInt(request.queryParams("age"));
          int attack = Integer.parseInt(request.queryParams("attack"));
          int defense = Integer.parseInt(request.queryParams("defense"));
          Cobra newCobra = new Cobra(name, age, power, attack, defense);

          model.put("squads", Squad.all());
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads/new", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("cobras", Cobra.all());
          model.put("template", "templates/squad-form.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/index.vtl");
          model.put("squads", Squad.all());
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/squads", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          String name = request.queryParams("name");
          String cause = request.queryParams("cause");
          String[] selectedCobras = request.queryParamsValues("cobras");
          Squad newSquad = new Squad(name, cause);
          for (String cobra : selectedCobras) {
            newSquad.addCobra(Cobra.getCobra(cobra));
          }
          model.put("squads", Squad.all());

          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads/:squadID", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("squad", Squad.all().get(request.params(":squadID")));
          model.put("template", "templates/squad.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/squads/:squadID", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          String[] selectedCobras = request.queryParamsValues("cobras");
          Squad currentSquad = Squad.all().get(request.params(":squadID"));
          for (String cobra : selectedCobras) {
            currentSquad.addCobra(Cobra.getCobra(cobra));
          }

          model.put("squad", currentSquad);
          model.put("template", "templates/squad.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads/:squadID/cobras/new", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("squadID", request.params(":squadID"));
          model.put("cobras", Cobra.getAvailableCobra());
          model.put("template", "templates/available-cobras.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squads/:squadID/cobras/:cobraID", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("squadID", request.params(":squadID"));
          model.put("cobra", Cobra.getCobra(request.params(":cobraID")));
          model.put("template", "templates/cobra.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



  }

}
