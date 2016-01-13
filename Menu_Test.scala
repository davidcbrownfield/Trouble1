import org.scalatest.Matchers
import org.scalatest.FunSpec

class Menu_Test extends FunSpec with Matchers {
  
   describe("A menu checker") {
    describe("determines a basic working menu") {
      it("rejects play-order based on incorrect placement of initial rolls") {

		val highLo = (("Alice", 6), ("Bob", 4), ("Carl", 3), ("Doug", 1))
		val loHigh = (("Chuck", 1), ("Steve", 2), ("Carl", 3), ("Sam", 5))
		val random  = (("Chuck", 2), ("Bob", 4), ("Carl", 3), ("Doug", 1))
		val badName  = ((" ", 2), ("Bob", 4), ("Carl", 5), ("Doug", 6))
		val badNum = (("Alice", 6), ("Bob", 4), ("Carl", 3), ("Doug", 7))

		menu.showPlayerOrder(highLo) shouldBe true
		enu.showPlayerOrder(loHigh) shouldBe false
		menu.showPlayerOrder(random) shouldBe false
		menu.showPlayerOrder(badName) shouldBe false
		menu.showPlayerOrder(badNum) shouldBe false
		
		
    }
	  it ("checks that the order of players advances correctly"){
	  
		  val start = ("Alice", "Bob", "Carl", "Doug") 
		  val next1 = ("Bob", "Carl", "Doug", "Alice")
		  val next2 = ("Carl", "Doug", "Alice", "Bob")
		  val next3 = ("Doug", "Alice", "Bob", "Carl")
		  
		  menu.advanceOrder(start) should equal(next1)
		  menu.advanceOrder(next1) should equal(next2)
		  menu.advanceOrder(next2) should equal(next3)
		  menu.advanceOrder(next3) should equal(start)
	  
    }
	
	it ("test whether all game area elements are visible and functional"){
	
		(board, pegs, die) = menu.showGame(validGame)
		(iboard, ipegs, idie) = menu.showGame(invalidGame)
		
		board.isValid() shouldBe true
		pegs.isValid() shouldBe true
		die.isValid() shouldBe true
		
		iboard.isValid() shouldBe false
		ipegs.isValid() shouldBe true
		idie.isValid() shouldBe true
	  }
  }
}
}