main :: IO ()
main = do
    putStr "Games sold by Catarina: "
    quantitySold <- readLn :: IO Int

    let costPerGame = 19.90
        totalSales = fromIntegral quantitySold * costPerGame
        bonus = (fromIntegral quantitySold / 15) * 0.08 * totalSales
        salary = 0.5 * totalSales
        totalEarnings = salary + bonus

    print totalSales
    print bonus
    print totalEarnings
