
import chisel3.emitVerilog
import fact.Fact

object Main extends App {
  emitVerilog(new Fact(), Array.concat(args, Array("-td=./src/hdl")))
}
