$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("integration/specs/simple/SimpleObjectSpec_listAllAndCreate.feature");
formatter.feature({
  "id": "list-and-create-new-simple-objectts",
  "tags": [
    {
      "name": "@SimpleObjectsFixture",
      "line": 17
    }
  ],
  "description": "",
  "name": "List and Create New Simple Objectts",
  "keyword": "Feature",
  "line": 18,
  "comments": [
    {
      "value": "#",
      "line": 1
    },
    {
      "value": "#  Licensed to the Apache Software Foundation (ASF) under one or more",
      "line": 2
    },
    {
      "value": "#  contributor license agreements.  See the NOTICE file distributed with",
      "line": 3
    },
    {
      "value": "#  this work for additional information regarding copyright ownership.",
      "line": 4
    },
    {
      "value": "#  The ASF licenses this file to You under the Apache License, Version 2.0",
      "line": 5
    },
    {
      "value": "#  (the \"License\"); you may not use this file except in compliance with",
      "line": 6
    },
    {
      "value": "#  the License.  You may obtain a copy of the License at",
      "line": 7
    },
    {
      "value": "#",
      "line": 8
    },
    {
      "value": "#     http://www.apache.org/licenses/LICENSE-2.0",
      "line": 9
    },
    {
      "value": "#",
      "line": 10
    },
    {
      "value": "#  Unless required by applicable law or agreed to in writing, software",
      "line": 11
    },
    {
      "value": "#  distributed under the License is distributed on an \"AS IS\" BASIS,",
      "line": 12
    },
    {
      "value": "#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.",
      "line": 13
    },
    {
      "value": "#  See the License for the specific language governing permissions and",
      "line": 14
    },
    {
      "value": "#  limitations under the License.",
      "line": 15
    },
    {
      "value": "#",
      "line": 16
    }
  ]
});
formatter.before({
  "duration": 142640469,
  "status": "passed"
});
formatter.before({
  "duration": 89252627,
  "status": "passed"
});
formatter.scenario({
  "id": "list-and-create-new-simple-objectts;existing-simple-objects-can-be-listed-and-new-ones-created",
  "tags": [
    {
      "name": "@unit",
      "line": 24
    }
  ],
  "description": "",
  "name": "Existing simple objects can be listed and new ones created",
  "keyword": "Scenario",
  "line": 25,
  "type": "scenario",
  "comments": [
    {
      "value": "# the scenario is listed twice here just to demonstrate that it",
      "line": 20
    },
    {
      "value": "# can be run either at @unit-level scope (using mocks) or",
      "line": 21
    },
    {
      "value": "# at @integration-level scope (against the running system).",
      "line": 22
    }
  ]
});
formatter.step({
  "name": "there are initially 3 simple objects",
  "keyword": "Given ",
  "line": 26
});
formatter.step({
  "name": "I create a new simple object",
  "keyword": "When ",
  "line": 27
});
formatter.step({
  "name": "there are 4 simple objects",
  "keyword": "Then ",
  "line": 28
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 20
    }
  ],
  "location": "SimpleObjectGlue.there_are_N_simple_objects(int)"
});
formatter.result({
  "duration": 818074440,
  "status": "passed"
});
formatter.match({
  "location": "SimpleObjectGlue.I_create_a_new_simple_object()"
});
formatter.result({
  "duration": 88682255,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 10
    }
  ],
  "location": "SimpleObjectGlue.there_are_N_simple_objects(int)"
});
formatter.result({
  "duration": 652495,
  "status": "passed"
});
formatter.after({
  "duration": 254069,
  "status": "passed"
});
formatter.before({
  "duration": 7669032203,
  "status": "passed"
});
formatter.before({
  "duration": 243152970,
  "status": "passed"
});
formatter.scenario({
  "id": "list-and-create-new-simple-objectts;existing-simple-objects-can-be-listed-and-new-ones-created",
  "tags": [
    {
      "name": "@integration",
      "line": 31
    }
  ],
  "description": "",
  "name": "Existing simple objects can be listed and new ones created",
  "keyword": "Scenario",
  "line": 32,
  "type": "scenario"
});
formatter.step({
  "name": "there are initially 3 simple objects",
  "keyword": "Given ",
  "line": 33
});
formatter.step({
  "name": "I create a new simple object",
  "keyword": "When ",
  "line": 34
});
formatter.step({
  "name": "there are 4 simple objects",
  "keyword": "Then ",
  "line": 35
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 20
    }
  ],
  "location": "SimpleObjectGlue.there_are_N_simple_objects(int)"
});
formatter.result({
  "duration": 215524897,
  "status": "passed"
});
formatter.match({
  "location": "SimpleObjectGlue.I_create_a_new_simple_object()"
});
formatter.result({
  "duration": 1824035,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 10
    }
  ],
  "location": "SimpleObjectGlue.there_are_N_simple_objects(int)"
});
formatter.result({
  "duration": 10665764,
  "status": "passed"
});
formatter.after({
  "duration": 10806913,
  "status": "passed"
});
});