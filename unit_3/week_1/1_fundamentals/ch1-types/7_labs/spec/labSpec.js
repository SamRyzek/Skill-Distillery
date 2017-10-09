var expect = chai.expect;

describe("Datatypes Test Suite", function() {
  describe("1: Create variables to hold the following information about a dog:", function() {
    describe("'name' variable", function() {
      it("'name' variable is defined.", function() {
        expect(name).to.not.be.undefined;
      });

      it("'name' is a string.", function() {
        expect(name).to.be.a('string');
      });
    });
    describe("'weight' variable", function() {
      it("'weight' variable is defined.", function() {
        expect(weight).to.not.be.undefined;
      });

      it("'weight' is a number.", function() {
        expect(weight).to.be.a('number');
      });
    });
    describe("'tailLength' variable", function() {
      it("'tailLength' variable is defined.", function() {
        expect(tailLength).to.not.be.undefined;
      });

      it("'tailLength' is a number.", function() {
        expect(tailLength).to.be.a('number');
      });
    });
    describe("'isFriendly' variable", function() {
      it("'isFriendly' variable is defined.", function() {
        expect(isFriendly).to.not.be.undefined;
      });

      it("'isFriendly' is a boolean.", function() {
        expect(isFriendly).to.be.a('boolean');
      });
    });
  });
  describe("2: Use 'console.log(msg)' to log the value of each of the variables to the console.", function() {
    it("There are no tests for this section: refer to the console to view the output. (open the Chrome developer console with [⌘ + ⌥ + j])", function() {
    });
  });
  describe("3: Re-assign the following variables with boolean values.", function() {
      it("'age' is a boolean", function() {
        expect(age).to.be.a('boolean');
      });
      it("'address' is a boolean", function() {
        expect(address).to.be.a('boolean');
      });
      it("'date' is a boolean", function() {
        expect(date).to.be.a('boolean');
      });
      it("'url' is a boolean", function() {
        expect(url).to.be.a('boolean');
      });
  });
  describe(`4: Create an array literal in a variable named 'months', add each
    of the twelve months stored as strings. Use 'console.log()'' to log the
    month you were born.`, function() {
    it("Contains the string January", function() {
      expect(months[0]).to.equal('January');
    });
    it("Contains the string February", function() {
      expect(months[1]).to.equal('February');
    });
    it("Contains the string March", function() {
      expect(months[2]).to.equal('March');
    });
    it("Contains the string April", function() {
      expect(months[3]).to.equal('April');
    });
    it("Contains the string May", function() {
      expect(months[4]).to.equal('May');
    });
    it("Contains the string June", function() {
      expect(months[5]).to.equal('June');
    });
    it("Contains the string July", function() {
      expect(months[6]).to.equal('July');
    });
    it("Contains the string August", function() {
      expect(months[7]).to.equal('August');
    });
    it("Contains the string September", function() {
      expect(months[8]).to.equal('September');
    });
    it("Contains the string October", function() {
      expect(months[9]).to.equal('October');
    });
    it("Contains the string November", function() {
      expect(months[10]).to.equal('November');
    });
    it("Contains the string December", function() {
      expect(months[11]).to.equal('December');
    });
  });
  describe(`5: Use 'console.log(msg)' to log the month you were born by
    accessing its index from the array.`, function(){
      it(`There are no tests for this section: refer to the console to view the
        output.`, function(){})
    });
  describe(`6: Declare a variable 'person', but don't initialize it with a
    variable. Use 'console.log(msg)' to print out the variable, what is the
    result?`, function() {
    it("person is undefined", function() {
      expect(person).to.not.be.defined;
    });
  });
});
