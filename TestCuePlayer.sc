
/*
  Run by evaluating:
    TestCuePlayer.new.run;
*/

TestCuePlayer : UnitTest {

  setUp {
    // this will be called before each test
  }

  tearDown {
    // this will be called after each test
  }

  test_cueplayer_put { var result;
    var cuePlayer = CuePlayer.new;
    cuePlayer.add({result = 'cue 1'});
    cuePlayer.add({result = 'cue 2'});
    cuePlayer.add({result = 'cue 3'});
    cuePlayer.put(2, {result = 'cue 2 replacement from .put'});
    cuePlayer.next;
    this.assertEquals(result, 'cue 1');
    cuePlayer.next;
    this.assertEquals(result, 'cue 2 replacement from .put');
    cuePlayer.next;
    this.assertEquals(result, 'cue 3');
  }
  
  test_cueplayer_add { var result;
    var cuePlayer = CuePlayer.new;
    cuePlayer.add({result = 'cue 1'});
    cuePlayer.next;
    this.assertEquals(result, 'cue 1');
  }

  test_cueplayer_trigger { var result;
    var cuePlayer = CuePlayer.new;
    cuePlayer.add({result = 'cue 1'});
    cuePlayer.add({result = 'cue 2'});
    cuePlayer.add({result = 'cue 3'});
    cuePlayer.put(2, {result = 'cue 2 replacement from .put'});
    cuePlayer.trigger(1);
    this.assertEquals(result, 'cue 1');
    cuePlayer.trigger(2);
    this.assertEquals(result, 'cue 2 replacement from .put');
    cuePlayer.trigger(3);
    this.assertEquals(result, 'cue 3');
    cuePlayer.trigger(1);
    this.assertEquals(result, 'cue 1');
  }

  test_cueplayer_blockTrigger { var result;
    var cuePlayer = CuePlayer.new;
    cuePlayer.blockTrigger(1);
    cuePlayer.add({result = 'cue 1'});
    cuePlayer.add({result = 'I am triggered!'});
    cuePlayer.put(30, {result = 'cue 30'});
    {
      30.do{
        cuePlayer.next;
        0.01.wait;
      };
      this.assertEquals(result, 'cue 1', report: false, onFailure: {"\n\nfailed blockTrigger test".postln});
      cuePlayer.blockTrigger(0);
      29.do{
        cuePlayer.next;
        0.01.wait;
      };
      this.assertEquals(result, 'cue 30', report: false, onFailure: {"\n\nfailed blockTrigger test".postln});
    }.asRoutine.play;
  }

  test_cueplayer_setCurrent { var result;
    var cuePlayer = CuePlayer.new;
    cuePlayer.add({result = 'cue 1'});
    cuePlayer.add({result = 'cue 2'});
    cuePlayer.next;
    cuePlayer.setCurrent(0);
    cuePlayer.next;
    this.assertEquals(result, 'cue 1');
  }

}
