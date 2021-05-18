package ga.veee
package sandbox

object Fan {
  final val OFF: Int = 0;
  final val LEVEL1: Int = 1;
  final val LEVEL2: Int = 2;
  final val LEVEL3: Int = 3;
  var state: Int = OFF

  def pullChain(): Unit = {
    if (state == LEVEL1) {
      println("Switching to Level 2")
      state = LEVEL2
    } else if (state == LEVEL2) {
      println("Switching to Level 3")
      state = LEVEL3
    } else if (state == LEVEL3) {
      println("Turning fan off.");
      state = OFF
    } else if (state == OFF) {
      println("Turning fan on.");
      println("Switching to Level 1")
      state = LEVEL1
    }
  }
}

object Human {

  def main(args: Array[String]): Unit = {
    Fan.pullChain()
    Fan.pullChain()
    Fan.pullChain()
    Fan.pullChain()
  }
}

object StateFan {
  private var fanState: FanState = OFF

  def pullChain(): Unit = fanState.pullChain()

  trait FanState {
    def pullChain()
  }

  object ON extends FanState {
    override def pullChain(): Unit = {
      println("Switching to Level 2")
      fanState = Level1
    }
  }

  object Level1 extends FanState {
    override def pullChain(): Unit = {
      println("Switching to Level 3")
      fanState = Level2
    }
  }

  object Level2 extends FanState {
    override def pullChain(): Unit = {
      println("Turning fan off.")
      fanState = OFF
    }
  }

  object OFF extends FanState {
    override def pullChain(): Unit = {
      println("Turning fan on.")
      println("Switching to Level 1")
      fanState = ON
    }
  }

  def main(args: Array[String]): Unit = {
    pullChain()
    pullChain()
    pullChain()
    pullChain()
  }

}
