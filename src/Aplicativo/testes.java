package Aplicativo;

import java.util.Arrays;

public class testes {

	public static int[] mostPopular(int[] populares) {
		int[] ret = new int[4];
		for (int i = 0; i < 4; i++) {
			ret[i] = mostPopularr(populares, ret);
		}
		
		boolean repete = true;
		while(repete) {
			repete = false;
			int cont = 0, valorAnt = 0;
			Arrays.sort(ret);
			for (int i : ret) {
				if(cont == 0) {
					cont++;
					valorAnt = i;
				} else {
					if(i == valorAnt){// ------
						i = valorNovo(populares, ret);
//						repete = true;
					}
					valorAnt = i;
				}
				
			}
		}
		
		return ret;
	}
	private static int valorNovo(int[] populares, int[] ignora) {
		boolean passa;
		for (int i : populares) {
			passa = existeEm(ignora, i);
			if (!passa) {
				return i;
			}
		}
		return 1;
	}
	private static int mostPopularr(int[] a, int[] ignorar){
		int count = 1, tempCount;
		int popular = a[0];
		int temp = 0;
		
		int len = ignorar.length; boolean passa = true;
		for (int i = 0; i < (a.length - 1); i++)
		{
			temp = a[i];
			for (int k = 0; k < len; k++) {
				passa = existeEm(ignorar, temp);
				if(!passa) {
					tempCount = 0;
					for (int j = 1; j < a.length; j++)
					{
						if (temp == a[j])
							tempCount++;
					}
					if (tempCount > count)
					{
						popular = temp;
						count = tempCount;
					}
				}
			}
		}
		return popular;
	}
	private static int mostPopularr(int[] a, int ignorar){
		int count = 1, tempCount;
		int popular = a[0];
		int temp = 0;
		
		int len = 1; boolean passa = true;
		for (int i = 0; i < (a.length - 1); i++)
		{
			temp = a[i];
			for (int k = 0; k < len; k++) {
				passa = ignorar == temp;
				if(!passa) {
					tempCount = 0;
					for (int j = 1; j < a.length; j++)
					{
						if (temp == a[j])
							tempCount++;
					}
					if (tempCount > count)
					{
						popular = temp;
						count = tempCount;
					}
				}
			}
		}
		return popular;
	}
	private static int mostPopularr(int[] a){
		int count = 1, tempCount;
		int popular = a[0];
		int temp = 0;
		for (int i = 0; i < (a.length - 1); i++)
		{
			temp = a[i];
			tempCount = 0;
			for (int j = 1; j < a.length; j++)
			{
				if (temp == a[j])
					tempCount++;
			}
			if (tempCount > count)
			{
				popular = temp;
				count = tempCount;
			}
		}
		return popular;
	}
	private static boolean existeEm(int[] array, int valor) {
		boolean ret = false;
		for (int i : array) {
			if (i == valor) {
				return true;
			}
		}
		return ret;
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
//		int[] values = {1,2,2,3,3,5,5,5,7,7,7,7};
		int[] values = {100, 500, 400, 500, 500};
		int[] ignorar = {5, 7};
//		System.out.println(mostPopular(values));
//		System.out.println(mostPopular(values, 7));
//		System.out.println(mostPopular(values, ignorar));
		int ret[] = mostPopular(values);
		for (int i : ret) {
			System.out.println(i);
		}
	}

}
