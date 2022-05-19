# Generate Verilog code
doit:
	sbt run

# Run the test
test:
	sbt test

clean:
	git clean -fd

