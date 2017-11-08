# Google Calendar

### Overview
This is a brief example of how you can use Angular to communicate with a users existing Google Calendar. This example illustrates the handshake process and illustrates how to display a list of calendar events. For additional options, and the ability to create events refer to the Google Calendar documentation.

***NOTE***: this does not cover how to display this in a format that looks like a calendar. You will need to find or implement your own display solution.

***NOTE***: You will need to retrieve your own API_KEY and CLIENT_ID from Google, if you do not already have them, go to the Google Developer's console and register an account, create an application and retrieve the required values.

### Dependencies
* AngularJS
* Google API

```html
<!DOCTYPE html>
<html ng-app="appModule">
<head>
	<title>Google Test</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.7/angular.min.js"></script>
	<script src="https://apis.google.com/js/api.js"></script>
</head>
<body>
	<my-cal></my-cal>
</body>
</html>
```

```js
// app.module.js
angular.module("appModule", []);
```

```js
// calendar.service.js
angular.module("appModule")
  .factory('calendarService', function($http) {
    var service = {};

    var GoogleAuth;

    var SCOPES = "https://www.googleapis.com/auth/calendar";

    var CLIENT_ID = 'YOUR_CLIENT_ID_GOES_HERE.apps.googleusercontent.com';
    var API_KEY = 'YOUR_API_KEY_GOES_HERE';

    var DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest"];

    /**
     *  On load, called to load the auth2 library and API client library.
     */
    service.handleClientLoad = function() {
          gapi.load('client:auth2', initClient);
    }

    /**
     *  Initializes the API client library and sets up sign-in state
     *  listeners.
     */
    function initClient() {
      gapi.client.init({
        apiKey: API_KEY,
        clientId: CLIENT_ID,
        discoveryDocs: DISCOVERY_DOCS,
        scope: SCOPES
      }).then(function () {
        // Listen for sign-in state changes.
        gapi.auth2.getAuthInstance().isSignedIn.listen(updateSigninStatus);

        // Handle the initial sign-in state.
        updateSigninStatus(gapi.auth2.getAuthInstance().isSignedIn.get());
        console.log("here")
      });
    }

    /**
     *  Called when the signed in status changes, to update the UI
     *  appropriately. After a sign-in, the API is called.
     *  NOTE : This could be used to set status / fire events in app
     */
    function updateSigninStatus(isSignedIn) {
        if (isSignedIn) {
          console.log("is signed in")
        } else {
          console.log("is not signed in")
        }
      }

      /**
       *  Sign in the user upon button click (or confirm auth given by logged in user).
       */
      service.signIn = function() {
        return gapi.auth2.getAuthInstance().signIn();
      }

      /**
       *  Sign out the user upon button click.
       */
      service.signOut = function(event) {
        return gapi.auth2.getAuthInstance().signOut();
      }

      /**
       *  Request event list from current date/time
       */
      service.getUpcomingEvents = function() {
          return gapi.client.calendar.events.list({
            'calendarId': 'primary', // google calendar id
            'timeMin': (new Date()).toISOString(),
            'showDeleted': false,
            'singleEvents': true,
            'maxResults': 10,
            'orderBy': 'startTime'
          })
      }

  return service;
})
```

```js
// myCal.component.js
angular.module("appModule")
.component('myCal', {
  template : `
    <button ng-click="vm.googleLogin()">Login</button>
    <button ng-click="vm.googleLogout()">Logout</button>

    <div ng-repeat="ev in vm.events">
      <div>Event : {{ev.summary}}</div>
      <div>Start : {{ev.start.date}}</div>
      <div>---------------------------</div>
    </div>
  `,
  controller : function(calendarService, $scope) {
    var vm = this;
    vm.events = [];

    calendarService.handleClientLoad();

    vm.googleLogin = function() {
      calendarService.signIn()
        .then(function(res) {
            calendarService.getUpcomingEvents()
              .then(function(res) {
                vm.events = res.result.items // the actual calendar events
                $scope.$apply();
              });
        });
    };

    vm.googleLogout = function() {
      calendarService.signOut()
        .then(function(res) {
          vm.events = [];
          $scope.$apply();
        });
    };
  },
  controllerAs : 'vm'
})
```
