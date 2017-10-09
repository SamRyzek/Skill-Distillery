#### Create a table dynamically

0: Create an HTML file named 'table.html', create a JS file named 'table.js'

1: Create a button with the text 'Show States'.

2: Add an event listener to the 'Show States' button that dynamically builds a table with the data below. These values should not be hard coded, don't all of the state objects have the same properties?:

```javascript
var usStates = [
    { name: 'ALABAMA', abbr: 'AL'},
    { name: 'ALASKA', abbr: 'AK'},
    { name: 'ARIZONA', abbr: 'AZ'},
    { name: 'ARKANSAS', abbr: 'AR'},
    { name: 'CALIFORNIA', abbr: 'CA'},
    { name: 'COLORADO', abbr: 'CO'},
    { name: 'CONNECTICUT', abbr: 'CT'},
    { name: 'DELAWARE', abbr: 'DE'},
    { name: 'DISTRICT OF COLUMBIA', abbr: 'DC'},
    { name: 'FLORIDA', abbr: 'FL'},
    { name: 'GEORGIA', abbr: 'GA'},
    { name: 'HAWAII', abbr: 'HI'},
    { name: 'IDAHO', abbr: 'ID'},
    { name: 'ILLINOIS', abbr: 'IL'},
    { name: 'INDIANA', abbr: 'IN'},
    { name: 'IOWA', abbr: 'IA'},
    { name: 'KANSAS', abbr: 'KS'},
    { name: 'KENTUCKY', abbr: 'KY'},
    { name: 'LOUISIANA', abbr: 'LA'},
    { name: 'MAINE', abbr: 'ME'},
    { name: 'MARYLAND', abbr: 'MD'},
    { name: 'MASSACHUSETTS', abbr: 'MA'},
    { name: 'MICHIGAN', abbr: 'MI'},
    { name: 'MINNESOTA', abbr: 'MN'},
    { name: 'MISSISSIPPI', abbr: 'MS'},
    { name: 'MISSOURI', abbr: 'MO'},
    { name: 'MONTANA', abbr: 'MT'},
    { name: 'NEBRASKA', abbr: 'NE'},
    { name: 'NEVADA', abbr: 'NV'},
    { name: 'NEW HAMPSHIRE', abbr: 'NH'},
    { name: 'NEW JERSEY', abbr: 'NJ'},
    { name: 'NEW MEXICO', abbr: 'NM'},
    { name: 'NEW YORK', abbr: 'NY'},
    { name: 'NORTH CAROLINA', abbr: 'NC'},
    { name: 'NORTH DAKOTA', abbr: 'ND'},
    { name: 'OHIO', abbr: 'OH'},
    { name: 'OKLAHOMA', abbr: 'OK'},
    { name: 'OREGON', abbr: 'OR'},
    { name: 'PENNSYLVANIA', abbr: 'PA'},
    { name: 'RHODE ISLAND', abbr: 'RI'},
    { name: 'SOUTH CAROLINA', abbr: 'SC'},
    { name: 'SOUTH DAKOTA', abbr: 'SD'},
    { name: 'TENNESSEE', abbr: 'TN'},
    { name: 'TEXAS', abbr: 'TX'},
    { name: 'UTAH', abbr: 'UT'},
    { name: 'VERMONT', abbr: 'VT'},
    { name: 'VIRGINIA', abbr: 'VA'},
    { name: 'WASHINGTON', abbr: 'WA'},
    { name: 'WEST VIRGINIA', abbr: 'WV'},
    { name: 'WISCONSIN', abbr: 'WI'},
    { name: 'WYOMING', abbr: 'WY' }
];
```

Remember that tables follow the following structure:
```html
<table>
  <thead>
      <th></th>
  </thead>
  <tbody>
    <tr>
      <td></td>
    </tr>
  </tbody>
</table>
```

3: When the table is written, replace the 'Show States' button with a 'Clear States' button that removes the table and replaces the 'Clear States' button with a 'Show States' button.
