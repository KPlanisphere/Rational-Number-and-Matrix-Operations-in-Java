# Rational Number and Matrix Operations in Java

This repository contains a Java project for performing arithmetic operations on rational numbers and operations on matrices of rational numbers. The project includes classes for defining rational numbers, handling matrix operations, and managing user input to display the results.

## Features

- **Rational Number Representation**: Defines rational numbers with methods for basic arithmetic operations and simplification.
- **Matrix Operations**: Implements operations such as addition, subtraction, and multiplication for matrices of rational numbers.
- **User Interaction**: Handles user input to create rational numbers and matrices and perform various operations.
- **Result Display**: Outputs the results of arithmetic and matrix operations.

### Code Snippets

#### Main Class
The main class initializes the program, handles user input, and invokes methods for arithmetic and matrix operations.

```java
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Rational number operations
        System.out.print("Enter numerator for the first rational number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter denominator for the first rational number: ");
        int den1 = scanner.nextInt();
        TRacional r1 = new TRacional(num1, den1);

        System.out.print("Enter numerator for the second rational number: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter denominator for the second rational number: ");
        int den2 = scanner.nextInt();
        TRacional r2 = new TRacional(num2, den2);

        TOperaRacionales ops = new TOperaRacionales();
        System.out.println("Sum: " + ops.add(r1, r2));
        System.out.println("Difference: " + ops.subtract(r1, r2));
        System.out.println("Product: " + ops.multiply(r1, r2));
        System.out.println("Quotient: " + ops.divide(r1, r2));

        // Matrix operations
        System.out.print("Enter the number of rows for the matrices: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for the matrices: ");
        int cols = scanner.nextInt();

        TMatrizRacional m1 = new TMatrizRacional(rows, cols);
        TMatrizRacional m2 = new TMatrizRacional(rows, cols);

        System.out.println("Enter elements for the first matrix:");
        m1.readMatrix(scanner);
        System.out.println("Enter elements for the second matrix:");
        m2.readMatrix(scanner);

        TOpMatricesRacionales matrixOps = new TOpMatricesRacionales();
        System.out.println("Matrix Sum:");
        matrixOps.add(m1, m2).printMatrix();
        System.out.println("Matrix Difference:");
        matrixOps.subtract(m1, m2).printMatrix();
        System.out.println("Matrix Product:");
        matrixOps.multiply(m1, m2).printMatrix();
    }
}
```

#### Rational Number Class

The `TRacional` class represents a rational number and includes methods for arithmetic operations and simplification.

```java
public class TRacional {
    private int numerator;
    private int denominator;

    public TRacional(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
```

#### Matrix Class

The `TMatrizRacional` class represents a matrix of rational numbers and includes methods for reading and printing matrices.

```java
public class TMatrizRacional {
    private TRacional[][] matrix;
    private int rows;
    private int cols;

    public TMatrizRacional(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new TRacional[rows][cols];
    }

    public void readMatrix(Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter numerator for element [" + i + "][" + j + "]: ");
                int num = scanner.nextInt();
                System.out.print("Enter denominator for element [" + i + "][" + j + "]: ");
                int den = scanner.nextInt();
                matrix[i][j] = new TRacional(num, den);
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public TRacional getElement(int row, int col) {
        return matrix[row][col];
    }

    public void setElement(int row, int col, TRacional value) {
        matrix[row][col] = value;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
```

#### Operations Classes

The `TOperaRacionales` and `TOpMatricesRacionales` classes contain methods for performing operations on rational numbers and matrices.

```java
public class TOperaRacionales {
    public TRacional add(TRacional r1, TRacional r2) {
        int num = r1.getNumerator() * r2.getDenominator() + r2.getNumerator() * r1.getDenominator();
        int den = r1.getDenominator() * r2.getDenominator();
        return new TRacional(num, den);
    }

    public TRacional subtract(TRacional r1, TRacional r2) {
        int num = r1.getNumerator() * r2.getDenominator() - r2.getNumerator() * r1.getDenominator();
        int den = r1.getDenominator() * r2.getDenominator();
        return new TRacional(num, den);
    }

    public TRacional multiply(TRacional r1, TRacional r2) {
        int num = r1.getNumerator() * r2.getNumerator();
        int den = r1.getDenominator() * r2.getDenominator();
        return new TRacional(num, den);
    }

    public TRacional divide(TRacional r1, TRacional r2) {
        int num = r1.getNumerator() * r2.getDenominator();
        int den = r1.getDenominator() * r2.getNumerator();
        return new TRacional(num, den);
    }
}

public class TOpMatricesRacionales {
    public TMatrizRacional add(TMatrizRacional m1, TMatrizRacional m2) {
        int rows = m1.getRows();
        int cols = m1.getCols();
        TMatrizRacional result = new TMatrizRacional(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                TRacional sum = m1.getElement(i, j).add(m2.getElement(i, j));
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public TMatrizRacional subtract(TMatrizRacional m1, TMatrizRacional m2) {
        int rows = m1.getRows();
        int cols = m1.getCols();
        TMatrizRacional result = new TMatrizRacional(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                TRacional difference = m1.getElement(i, j).subtract(m2.getElement(i, j));
                result.setElement(i, j, difference);
            }
        }
        return result;
    }

    public TMatrizRacional multiply(TMatrizRacional m1, TMatrizRacional m2) {
        int rows = m1.getRows();
        int cols = m1.getCols();
        TMatrizRacional result = new TMatrizRacional(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                TRacional product = new TRacional(0, 1);
                for (int k = 0; k < cols; k++) {
                    TRacional temp = m1.getElement(i, k).multiply(m2.getElement(k, j));
                    product = product.add(temp);
                }
                result.setElement(i, j, product);
            }
        }
        return result;
    }
}
```

### Usage

1.  Compile the Java files using a Java compiler (e.g., `javac`).
2.  Run the main class (`Principal`) to start the program.
3.  Follow the prompts to enter the dimensions and elements of the matrices, and the values for the rational numbers.
4.  The program will perform the specified operations and display the results.

### Classes and Methods

-   `Principal`: The main class that handles user input and program execution.
    -   `main(String[] args)`: The entry point of the program.
-   `TRacional`: A class representing a rational number with methods for arithmetic operations and simplification.
    -   `TRacional(int numerator, int denominator)`: Constructor that initializes the rational number.
    -   `add(TRacional other)`, `subtract(TRacional other)`, `multiply(TRacional other)`, `divide(TRacional other)`: Methods for arithmetic operations.
    -   `toString()`: Method that returns the string representation of the rational number.
-   `TMatrizRacional`: A class representing a matrix of rational numbers with methods for reading and printing matrices.
    -   `TMatrizRacional(int rows, int cols)`: Constructor that initializes the matrix dimensions.
    -   `readMatrix(Scanner scanner)`: Method that reads matrix data from the user.
    -   `printMatrix()`: Method that prints the matrix.
    -   `getElement(int row, int col)`, `setElement(int row, int col, TRacional value)`: Methods to get and set matrix elements.
-   `TOperaRacionales`: A class containing methods for performing arithmetic operations on rational numbers.
    -   `add(TRacional r1, TRacional r2)`, `subtract(TRacional r1, TRacional r2)`, `multiply(TRacional r1, TRacional r2)`, `divide(TRacional r1, TRacional r2)`: Methods for arithmetic operations.
-   `TOpMatricesRacionales`: A class containing methods for performing operations on matrices of rational numbers.
    -   `add(TMatrizRacional m1, TMatrizRacional m2)`, `subtract(TMatrizRacional m1, TMatrizRacional m2)`, `multiply(TMatrizRacional m1, TMatrizRacional m2)`: Methods for matrix operations.