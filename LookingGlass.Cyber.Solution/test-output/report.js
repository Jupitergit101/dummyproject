$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/Homepage.feature");
formatter.feature({
  "name": "Dresses feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify user homepage Displayed",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Requested"
    }
  ]
});
formatter.step({
  "name": "Open the browser and enter the url",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.open_the_browser_and_enter_the_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user at homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.user_at_homepage()"
});
formatter.result({
  "status": "passed"
});
});