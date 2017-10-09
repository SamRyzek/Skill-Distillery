describe(`Basic Objects Lab`, function() {
  describe(`1: Assign the 'mage' variable an object literal ...  `, function() {
    it(`is defined`, function(){
      expect(mage).to.be.defined;
    });
    it(`is an object`, function(){
      expect(typeof mage).to.equal('object');
    });
    it(`has the expected properties`, function(){
      expect(mage.hp).to.be.defined;
      expect(mage.lvl).to.be.defined;
      expect(mage.name).to.be.defined;
      expect(mage.exp).to.be.defined;
      expect(mage.spells).to.be.defined;
    });
    it(`properties are the correct type`, function(){
      expect(typeof mage.hp).to.equal(`number`);
      expect(typeof mage.lvl).to.equal(`number`);
      expect(typeof mage.name).to.equal(`string`);
      expect(typeof mage.exp).to.equal(`number`);
      expect(typeof mage.spells).to.equal('object');
    });
  });
  describe(`2 : Assign the 'mage' object a method named 'learnSpell' ...`, function() {
    it(`is defined`, function() {
      expect(mage.learnSpell).to.be.defined;
    });
    it(`is a function`, function() {
      expect(typeof mage.learnSpell).to.equal('function');
    });
    it(`adds a spell if the spell is an object ...`, function() {
      var startingSpells = mage.spells;
      mage.spells = {};
      expect(mage.learnSpell({requiredLvl : 1, name : 'test'})).to.equal('I have learned test.');
      expect(typeof mage.spells['test']).to.equal('object');
      mage.spells = startingSpells;
    });
    it(`does not add a spell if the spell is not an object ...`, function() {
      var startingSpells = mage.spells;
      mage.spells = {};
      expect(mage.learnSpell('banana')).to.equal(`I do not yet possess the power to learn this.`);
      var spells = [];
      for (var p in mage.spells) {
        spells.push(p);
      }
      expect(spells.length).to.equal(0);
      mage.spells = startingSpells;
    });
  });
  describe(`3 : Assign the 'magicMissile' variable an object literal ...  `, function() {
    it(`is defined`, function(){
      expect(magicMissile).to.be.defined;
    });
    it(`is an object`, function(){
      expect(typeof magicMissile).to.equal('object');
    });
    it(`has the expected properties`, function(){
      expect(magicMissile.name).to.be.defined;
      expect(magicMissile.type).to.be.defined;
      expect(magicMissile.requiredLvl).to.be.defined;
    });
    it(`properties are the correct type`, function(){
      expect(typeof magicMissile.name).to.equal('string')
      expect(typeof magicMissile.type).to.equal('string')
      expect(typeof magicMissile.requiredLvl).to.equal('number')
    });
  });
  describe(`4 : Add a method to 'magicMissile' named 'resolve' ...  `,function(){
    it(`is defined`, function(){
      expect(magicMissile.resolve).to.be.defined;
    });
    it(`is a function`, function(){
      expect(typeof magicMissile.resolve).to.equal('function');
    });
    it(`returns a number between 4-7 (* lvl)`, function() {
      expect(magicMissile.resolve(mage, {hp:10})).to.be.within(4 * mage.lvl,7 * mage.lvl);
    });
    it(`effects the 'hp' of an object`, function() {
      var test = {hp:10 * mage.lvl};
      magicMissile.resolve(mage, test)
      expect(test.hp).to.be.within(3 * mage.lvl,6 * mage.lvl);
      expect(test.hp).to.below(7 * mage.lvl);
    })
  });
  describe(`5 : Add a method to 'mage' named 'castSpell' ...  `,function(){
    it(`is defined`, function(){
      expect(mage.castSpell).to.be.defined;
    });
    it(`is a function`, function(){
      expect(typeof mage.castSpell).to.equal('function');
    });
    it(`returns "I don't know that spell." if provided an unkown spell`, function() {
      expect(mage.castSpell('banana', {})).to.equal("I don't know that spell.");
    });
    it(`successfully uses a named spell if it is found`, function() {
      test = {hp:10 * mage.lvl};
      var spells = mage.spells;
      mage.spells = {};
      mage.learnSpell(magicMissile);
      test.hp = mage.castSpell('Magic Missile', test);
      if (typeof test.hp === 'number') {
        expect(test.hp).to.be.within(3 * mage.lvl,8 * mage.lvl);
        expect(test.hp).to.below(8 * mage.lvl);
      }
      mage.spells = spells;
    })
  });
  describe(`6 : Have your mage learn 'magicMissile' ...`, function() {
    it(`the mage knows magic missile`, function() {
      expect(mage.spells["Magic Missile"]).to.be.defined;
      expect(typeof mage.spells["Magic Missile"]).to.equal('object');
    });
  });
  describe(`7 : Assign the 'darkness' variable an object literal representing an opponent ...  `,function(){
    it(`is defined`, function() {
      expect(darkness).to.be.defined;
    });
    it(`is an object`, function() {
      expect(typeof darkness).to.equal('object');
    });
    it(`has the correct properties`, function() {
      expect(typeof darkness.name).to.equal('string');
      expect(typeof darkness.hp).to.equal('number');
    })
  });
  describe(`8 : Have your mage cast Magic Missile at the darkness ...`,function(){
    xit(`cast it...`,function(){});
    xit(`print out the darkness object to ensure it was damaged`,function(){});
  });
});
