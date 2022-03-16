// EXPAND ON THIS MORE BY GIVING MORE DETAILS LIKE PROFIT, COST, ETC...

/*-----------------------------------------------------------------------------------
// CSE 110		: Class #76232-76233
// Assignment	: Stock Market Calculator
// Author		: Alfonso Sanchez Gallegos
// Description	: Determines whether to buy, sell, or hold shares in a stock market.
-------------------------------------------------------------------------------------*/



import java.util.Scanner;

public class StockMarketCalculator
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		//Constant variables
		final int TRANSACTION_FEE = 10;		// 10 dollars

		//Input variables
		int currentShares = 0;
		int purchasePrice = 0;
		int marketPrice = 0;
		int availFunds = 0;

		// Output variables
		int numberOfSharesToBuy = 0;
		double totalBuyCost = 0.0;
		double perShareBuyValue = 0.0;
		double totalBuyValue = 0.0;
		double perShareSellValue = 0.0;
		double totalSellValue = 0.0;

		//Asks user for input
		System.out.print("Current Shares  : ");
		currentShares = in.nextInt();
		System.out.print("Purchase Price  : ");
		purchasePrice = in.nextInt();
		System.out.print("Market Price    : ");
		marketPrice = in.nextInt();
		System.out.print("Available Funds : ");
		availFunds = in.nextInt();

		// Equations worked out
		// Buy scenario
		numberOfSharesToBuy = (int) Math.floor((availFunds - TRANSACTION_FEE)/marketPrice);
		totalBuyCost = TRANSACTION_FEE + (marketPrice * numberOfSharesToBuy);
		perShareBuyValue = purchasePrice - marketPrice;
		totalBuyValue = perShareBuyValue * numberOfSharesToBuy;		// This has to be greater than TRANSACTION_FEE to be profitable
		// Sell scenario
		perShareSellValue = marketPrice - purchasePrice;
		totalSellValue = perShareSellValue * currentShares;			// This has to be greater than TRANSACTION_FEE to be profitable

		// Buy scenario
		if (purchasePrice > marketPrice)
		{
			if (totalBuyValue > TRANSACTION_FEE)
			{
				System.out.printf("Buy %d shares\n", numberOfSharesToBuy);
			}
			else
			{
				System.out.println("Hold shares");
			}
		}

		// Sell scenario
		else if (marketPrice > purchasePrice)
		{
			if (totalSellValue > TRANSACTION_FEE)
			{
				System.out.printf("Sell %d shares\n", currentShares);
			}
			else
			{
				System.out.println("Hold shares");
			}
		}

		// Purchase price and market price are equal
		else
		{
			System.out.println("Hold shares");
		}

		in.close();
	}
}