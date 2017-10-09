describe(`Key - Value Pair Lab Test Suite`, function() {
  describe(`getStateByAbbr...`, function() {
    it(`returns an object`, function() {
      expect(typeof getStateByAbbr('CO')).to.equal('object');
    });
    it(`returns the correct state`, function() {
      expect(getStateByAbbr('CO').name).to.equal('Colorado');
    });
  });
  describe(`getStateCapitalByAbbr...`, function() {
    it(`returns a string`, function() {
      expect(typeof getStateCapitalByAbbr('CO')).to.equal('string');
    });
    it(`returns the correct capital`, function() {
      expect(getStateCapitalByAbbr('CO')).to.equal('Denver');
    });
  });
  describe(`getStatesWithinDegreesOfLatLong ...`, function() {
    it(`returns an array`, function() {
      expect(Array.isArray(getStatesWithinDegreesOfLatLong())).to.be.true;
    });
    it(`contains the correct state(s) for input`, function() {
      expect(getStatesWithinDegreesOfLatLong(33,-112,1).length).to.equal(1);
      expect(getStatesWithinDegreesOfLatLong(33,-112,1)[0].name).to.equal('Arizona');
      expect(getStatesWithinDegreesOfLatLong(33,-112,10)[6].name).to.equal('Wyoming');

    });
  });
  describe(`countProperties ...`, function() {
    it(`returns a number`, function() {
      expect(typeof countProperties(states)).to.equal('number');
    });
    it(`has the correct value`, function() {
      expect(countProperties(states)).to.equal(50);
    });
  });
  describe(`logAccessByIp ...`, function() {
    it(`returns an object`, function() {
      expect(typeof logAccessByIp(ips)).to.equal('object');
    });
    it(`returns the correct counts`, function() {
      expect(logAccessByIp(ips)['64.124.58.155']).to.equal(8);
    });
  });
  describe(`formatGithubCommit ...`, function(){
    it(`returns an object`, function() {
      expect(typeof formatGithubCommit(commit)).to.equal('object');
    });
    it(`has the correct properties`, function() {
      let c = formatGithubCommit(commit);
      expect(c.hasOwnProperty('committer')).to.be.true;
      expect(c.hasOwnProperty('timestamp')).to.be.true;
      expect(c.hasOwnProperty('msg')).to.be.true;
      expect(c.hasOwnProperty('sha')).to.be.true;
    });
    it(`has the correct values`, function() {
      let c = formatGithubCommit(commit);
      expect(c.committer).to.equal("Scott Chacon");
      expect(c.timestamp).to.equal("2014-11-07T22:01:45Z");
      expect(c.msg).to.equal("added readme, because im a good github citizen");
      expect(c.sha).to.equal("691272480426f78a0138979dd3ce63b77f706feb");
    });
  });
});