SBT = sbt

# Generate Verilog code
doit:
	$(SBT) "runMain empty.AddMain"

# Run the test
test:
	$(SBT) "test:runMain empty.AddTester"

clean:
	git clean -fd

