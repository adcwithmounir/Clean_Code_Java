record OrdInfo(int id, String strCust, int st, double amt) {}

Map<Integer, OrdInfo> orderList = new HashMap<>();

void addOrd(OrdInfo o) { orderList.put(o.id(), o); }

List<OrdInfo> fetch() {
    List<OrdInfo> r = new ArrayList<>();
    for (OrdInfo o : orderList.values())
        if (o.st() == 3) r.add(o);
    return r;
}

double retrieveTot() {
    double t = 0;
    for (OrdInfo o : fetch()) t += o.amt() * 0.15;
    return t;
}

void main() {
    addOrd(new OrdInfo(101, "Lena", 3, 42.00));
    addOrd(new OrdInfo(102, "Sam", 1, 18.50));
    addOrd(new OrdInfo(103, "Ana", 3, 26.00));
    IO.println(fetch().size() + " " + "%.2f".formatted(retrieveTot()));
}
