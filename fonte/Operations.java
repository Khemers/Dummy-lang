import java.util.Arrays;
import java.util.Map;

public class Operations {

    public static int parse(Map<String, Variable> Variables, String[] lines, String line, int currentLine, int endLine, String type) throws ErrorTreatment {
        String[] strings;

        if (line.contains("==")) {
            strings = line.replace("'", "").trim().split(" ");

            if (Variables.containsKey(strings[0]) && Variables.containsKey(strings[2])) {
                if (Variables.get(strings[0]).ComparaIgual(Variables.get(strings[2]).getValue().toString())) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[0])) {
                if (Variables.get(strings[0]).ComparaIgual(strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[2])) {
                if (Variables.get(strings[2]).ComparaIgual(strings[0])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else {
                if (Math.comparaIgual(strings[0], strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            }
        } else if (line.contains("<=")) {
            strings = line.trim().split(" ");

            if (Variables.containsKey(strings[0]) && Variables.containsKey(strings[2])) {
                if (Variables.get(strings[0]).ComparaMenorIgual(Variables.get(strings[2]).getValue().toString())) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[0])) {
                if (Variables.get(strings[0]).ComparaMenorIgual(strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[2])) {
                if (Variables.get(strings[2]).ComparaMaiorIgual(strings[0])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            }  else {
                if (Math.comparaMenorIgual(strings[0], strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            }
        } else if (line.contains(">=")) {
            strings = line.trim().split(" ");

            if (Variables.containsKey(strings[0]) && Variables.containsKey(strings[2])) {
                if (Variables.get(strings[0]).ComparaMaiorIgual(Variables.get(strings[2]).getValue().toString())) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[0])) {
                if (Variables.get(strings[0]).ComparaMaiorIgual(strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[2])) {
                if (Variables.get(strings[2]).ComparaMenorIgual(strings[0])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else {
                if (Math.comparaMaiorIgual(strings[0], strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            }
        } else if (line.contains(">")) {
            strings = line.trim().split(" ");

            if (Variables.containsKey(strings[0]) && Variables.containsKey(strings[2])) {
                if (Variables.get(strings[0]).ComparaMaior(Variables.get(strings[2]).getValue().toString())) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[0])) {
                if (Variables.get(strings[0]).ComparaMaior(strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[2])) {
                if (Variables.get(strings[2]).ComparaMenor(strings[0])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else {
                if (Math.comparaMaior(strings[0], strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            }
        } else if (line.contains("<")) {
            strings = line.trim().split(" ");

            if (Variables.containsKey(strings[0]) && Variables.containsKey(strings[2])) {
                if (Variables.get(strings[0]).ComparaMenor(Variables.get(strings[2]).getValue().toString())) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[0])) {
                if (Variables.get(strings[0]).ComparaMenor(strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[2])) {
                if (Variables.get(strings[2]).ComparaMaior(strings[0])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else {
                if (Math.comparaMenor(strings[0], strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            }
        } else if (line.contains("!=")) {
            strings = line.trim().split(" ");

            if (Variables.containsKey(strings[0]) && Variables.containsKey(strings[2])) {
                if (Variables.get(strings[0]).ComparaDiferente(Variables.get(strings[2]).getValue().toString())) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[0])) {
                if (Variables.get(strings[0]).ComparaDiferente(strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (Variables.containsKey(strings[2])) {
                if (Variables.get(strings[2]).ComparaDiferente(strings[0])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else {
                if (Math.comparaDiferente(strings[0], strings[2])) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            }
        } else {
            strings = line.trim().split(" ");

            if (Variables.containsKey(strings[0])) {
                if (Variables.get(strings[0]).getValue() == (Object) true) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            } else if (line.contains("!")) {
                strings = line.replace("!", "").trim().split(" ");

                if (Variables.containsKey(strings[0])) {
                    if (Variables.get(strings[0]).getValue() == (Object) false) {
                        Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                        if (type.equals("if") && lines[endLine].contains("else")) {
                            return Parser.foundElse(lines, endLine, true);
                        }
                    } else {
                        if (type.equals("if") && lines[endLine].contains("else")) {
                            return Parser.foundElse(lines, endLine, false);
                        }
                        return endLine;
                    }
                }
            } else {
                if (strings[0].equals("true")) {
                    Parser.parseLines(Arrays.stream(lines, currentLine + 1, endLine).toArray(String[]::new));

                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, true);
                    }
                } else {
                    if (type.equals("if") && lines[endLine].contains("else")) {
                        return Parser.foundElse(lines, endLine, false);
                    }
                    return endLine;
                }
            }
        }
        if (type.equals("while")) {
            return currentLine - 1;
        }
        return endLine;
    }
}
