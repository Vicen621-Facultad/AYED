package ayed.tp3;

public class Test {
	public static void main(String[] args) {
		GeneralTree<Integer> root = new GeneralTree<>(1);
		GeneralTree<Integer> dos = new GeneralTree<>(2);
		GeneralTree<Integer> tres = new GeneralTree<>(3);
		GeneralTree<Integer> cuatro = new GeneralTree<>(4);
		GeneralTree<Integer> cinco = new GeneralTree<>(5);
		GeneralTree<Integer> seis = new GeneralTree<>(6);
		GeneralTree<Integer> siete = new GeneralTree<>(7);
		GeneralTree<Integer> ocho = new GeneralTree<>(8);
		GeneralTree<Integer> nueve = new GeneralTree<>(9);
		GeneralTree<Integer> diez = new GeneralTree<>(10);
		GeneralTree<Integer> once = new GeneralTree<>(11);
		GeneralTree<Integer> doce = new GeneralTree<>(12);
		GeneralTree<Integer> trece = new GeneralTree<>(13);
		GeneralTree<Integer> catorce = new GeneralTree<>(14);
		GeneralTree<Integer> quince = new GeneralTree<>(15);

		root.addChild(dos);
		root.addChild(tres);
		root.addChild(cuatro);

		dos.addChild(cinco);
		dos.addChild(seis);
		dos.addChild(siete);

		cuatro.addChild(ocho);
		cuatro.addChild(nueve);

		siete.addChild(diez);
		siete.addChild(once);

		nueve.addChild(doce);

		diez.addChild(trece);

		once.addChild(catorce);
		once.addChild(quince);

		System.out.println(root.nivel(13));
	}
}
