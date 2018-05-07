SBT = sbt

# Generate Verilog code
doit:
	$(SBT) "runMain empty.AddMain"

# Generate the C++ simulation and run the tests
test:
	$(SBT) "test:runMain empty.AddTester"

clean:
	git clean -fd

