$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("integration/specs/simple/SimpleObjectSpec_listAllAndCreate.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#"
    },
    {
      "line": 2,
      "value": "#  Licensed to the Apache Software Foundation (ASF) under one or more"
    },
    {
      "line": 3,
      "value": "#  contributor license agreements.  See the NOTICE file distributed with"
    },
    {
      "line": 4,
      "value": "#  this work for additional information regarding copyright ownership."
    },
    {
      "line": 5,
      "value": "#  The ASF licenses this file to You under the Apache License, Version 2.0"
    },
    {
      "line": 6,
      "value": "#  (the \"License\"); you may not use this file except in compliance with"
    },
    {
      "line": 7,
      "value": "#  the License.  You may obtain a copy of the License at"
    },
    {
      "line": 8,
      "value": "#"
    },
    {
      "line": 9,
      "value": "#     http://www.apache.org/licenses/LICENSE-2.0"
    },
    {
      "line": 10,
      "value": "#"
    },
    {
      "line": 11,
      "value": "#  Unless required by applicable law or agreed to in writing, software"
    },
    {
      "line": 12,
      "value": "#  distributed under the License is distributed on an \"AS IS\" BASIS,"
    },
    {
      "line": 13,
      "value": "#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied."
    },
    {
      "line": 14,
      "value": "#  See the License for the specific language governing permissions and"
    },
    {
      "line": 15,
      "value": "#  limitations under the License."
    },
    {
      "line": 16,
      "value": "#"
    }
  ],
  "line": 18,
  "name": "List and Create New Simple Objectts",
  "description": "",
  "id": "list-and-create-new-simple-objectts",
  "keyword": "Feature",
  "tags": [
    {
      "line": 17,
      "name": "@SimpleObjectsFixture"
    }
  ]
});
formatter.before({
  "duration": 153105714,
  "status": "passed"
});
formatter.before({
  "duration": 58712290,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 20,
      "value": "# the scenario is listed twice here just to demonstrate that it"
    },
    {
      "line": 21,
      "value": "# can be run either at @unit-level scope (using mocks) or"
    },
    {
      "line": 22,
      "value": "# at @integration-level scope (against the running system)."
    }
  ],
  "line": 25,
  "name": "Existing simple objects can be listed and new ones created",
  "description": "",
  "id": "list-and-create-new-simple-objectts;existing-simple-objects-can-be-listed-and-new-ones-created",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@unit"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "there are initially 3 simple objects",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "I create a new simple object",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "there are 4 simple objects",
  "keyword": "Then "
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
  "duration": 716597351,
  "status": "passed"
});
formatter.match({
  "location": "SimpleObjectGlue.I_create_a_new_simple_object()"
});
formatter.result({
  "duration": 36851547,
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
  "duration": 1015504,
  "status": "passed"
});
formatter.after({
  "duration": 445657,
  "status": "passed"
});
formatter.before({
  "duration": 8270923910,
  "status": "passed"
});
formatter.before({
  "duration": 238406159,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Existing simple objects can be listed and new ones created",
  "description": "",
  "id": "list-and-create-new-simple-objectts;existing-simple-objects-can-be-listed-and-new-ones-created",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 31,
      "name": "@integration"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "there are initially 3 simple objects",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "I create a new simple object",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "there are 4 simple objects",
  "keyword": "Then "
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
  "duration": 222324694,
  "status": "passed"
});
formatter.match({
  "location": "SimpleObjectGlue.I_create_a_new_simple_object()"
});
formatter.result({
  "duration": 3254953,
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
  "duration": 21518823,
  "status": "passed"
});
formatter.after({
  "duration": 22496274,
  "status": "passed"
});
});