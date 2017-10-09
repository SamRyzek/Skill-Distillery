describe(`jQuery Grandma Test Suite`, function() {
  it(`jQuery is included`, function() {
    expect($).to.be.defined;
  });
  describe(`1 : Build the conversation form`, function() {
    it(`the form has the id 'grandmaForm'`, function(){
      expect($('#grandmaForm')[0].localName).to.equal('form');
    });
    it(`the form has an input with the name 'say'`, function(){
      expect($('#grandmaForm input[name="say"]')[0].localName).to.equal('input');
    });
    it(`the form has an input with the type 'submit'`, function(){
      expect($('#grandmaForm input[type="submit"]')[0].localName).to.equal('input');
    });
  });
  describe(`2 : Create a div with the id 'conversation'`, function() {
    it(`there is a div with the id 'conversation'`, function(){
      expect($('#conversation')[0].localName).to.equal('div');
    });
  });
  describe(`3 : Talk to grandma ...`, function() {
    beforeEach(function() {
      $('#grandmaForm input[name="say"]').val('asdf');
      $('#grandmaForm input[type="submit"]').click();
    });
    afterEach(function() {
      $('#conversation').empty();
      $('#grandmaForm input[type="submit"]').off('click', listenToGrandmaForm);
      $('#grandmaForm input[type="submit"]').on('click', listenToGrandmaForm);
      $('#grandmaForm input[name="say"]').val('');
    });
    it(`clicking the submit creates a div inside of #conversation`, function () {
      var innerDivs = $('#conversation').children();
      expect(innerDivs.length).to.be.above(0);
    })
    it(`the added div contains the text entered in the form`, function () {
      var innerDivs = $('#conversation').children();
      var divContainsUserInput = false;
      innerDivs.each(function(idx) {
        if (idx === 0) {
          if ($(this).text().includes('asdf')) {
            divContainsUserInput = true;
          }
        }
      });
      expect(divContainsUserInput).to.be.true;
    })
    it(`grandma's response is also added to the #conversation div in a div`, function () {
      var innerDivs = $('#conversation').children();
      var divContainsUserInput = false;
      innerDivs.each(function(idx) {
        if (idx === 0) {
          if ($(this).text().includes('asdf')) {
            divContainsUserInput = true;
          }
        }
        if (idx === 1) {
          divContainsGrandmaResponse = ($(this).text()) ? true : false;
        }
      });
      expect(divContainsUserInput && divContainsGrandmaResponse).to.be.true;
    })
    it(`if user enters lowercase, grandma responds 'U WAT M8?'`, function () {
      var innerDivs = $('#conversation').children();
      var correctResponse = false;
      innerDivs.each(function(idx) {
        var text = $(this).text();
        if (idx % 2 === 0 && !text.includes(text.toUpperCase())) {
          correctResponse = ($(this)
            .next().text().includes('U WAT M8?')) ? true : false;
        }
      });
      expect(correctResponse).to.be.true;
    })
    it(`if user enters uppercase, grandma responds 'UR A n00b HACKZOR!'`, function () {
      $('#grandmaForm input[name="say"]').val('ASDF');
      $('#grandmaForm input[type="submit"]').click();
      var innerDivs = $('#conversation').children();
      var correctResponse = false;
      innerDivs.each(function(idx) {
        var text = $(this).text();
        if (idx % 2 === 0 && text.includes('ASDF')) {
          correctResponse = ($(this)
            .next().text().includes('UR A n00b HACKZOR!')) ? true : false;
        }
      });
      expect(correctResponse).to.be.true;
    })
    it(`if user enters 'GOODBYE!', grandma responds 'L8R M8'`, function () {
      $('#grandmaForm input[name="say"]').val('GOODBYE!');
      $('#grandmaForm input[type="submit"]').click();
      var innerDivs = $('#conversation').children();
      var correctResponse = false;
      innerDivs.each(function(idx) {
        var text = $(this).text();
        if (idx % 2 === 0 && text.includes('GOODBYE!')) {
          correctResponse = ($(this)
            .next().text().includes('L8R M8')) ? true : false;
        }
      });
      expect(correctResponse).to.be.true;
    })
  });
  describe(`4 : Disable conversation after goodbye`, function() {
    afterEach(function() {
      $('#conversation').empty();
      $('#grandmaForm input[type="submit"]').off('click', listenToGrandmaForm);
      $('#grandmaForm input[type="submit"]').on('click', listenToGrandmaForm);
      $('#grandmaForm input[name="say"]').val('');
    });
    xit(`removes the event listener from the button.`, function() {

    });
    it(`after goodbye, no more text should be appended to the conversation if the button is clicked.`, function() {
      $('#grandmaForm input[name="say"]').val('hello!');
      $('#grandmaForm input[type="submit"]').click();
      $('#grandmaForm input[name="say"]').val('GOODBYE!');
      $('#grandmaForm input[type="submit"]').click();
      var lengthAtGoodbye = $('#conversation').children().length;
      $('#grandmaForm input[name="say"]').val('hello!');
      $('#grandmaForm input[type="submit"]').click();
      var lengthAfter = $('#conversation').children().length;

      expect(lengthAtGoodbye === lengthAfter).to.be.true;
    });
  });
});