double calc(List<double[]> l, int t, boolean f) {
    double r = 0;
    for (int i = 0; i < l.size(); i++) {
        r = r + l.get(i)[0] * l.get(i)[1];
    }
    if (f && r > 20) {
        r = r - r * 0.1;
    }
    if (t == 1) r = r + 2.99;
    if (t == 2) r = r + 4.99;
    return Math.round(r * 100) / 100.0;
}

void main() {
    var l = List.of(new double[] {12.5, 2}, new double[] {6, 1});
    IO.println(calc(l, 2, true));
}
