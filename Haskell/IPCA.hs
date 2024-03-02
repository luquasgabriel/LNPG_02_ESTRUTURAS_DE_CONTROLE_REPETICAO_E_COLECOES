import Data.List (minimumBy, maximumBy)

data IPCAData = IPCAData { yearMonth :: String, indexValue :: Double }

main :: IO ()
main = do
    putStrLn "Enter IPCA data (year/month index). To finish, enter *:"
    processInput []

processInput :: [IPCAData] -> IO ()
processInput dataEntries = do
    input <- getLine
    if input == "*"
        then processResults dataEntries
        else do
            let (yearMonthStr:indexValueStr:_) = words input
                ipcData = IPCAData { yearMonth = yearMonthStr, indexValue = read indexValueStr }
            processInput (ipcData : dataEntries)

processResults :: [IPCAData] -> IO ()
processResults dataEntries = do
    let (lowestIPCA, highestIPCA, averageIPCA) = calculateResults dataEntries
    putStrLn $ "Lowest IPCA: " ++ showIPCA lowestIPCA
    putStrLn $ "Highest IPCA: " ++ showIPCA highestIPCA
    putStrLn $ "Average IPCA: " ++ show averageIPCA

calculateResults :: [IPCAData] -> (IPCAData, IPCAData, Double)
calculateResults dataEntries = (minimumBy compareIPCA dataEntries, maximumBy compareIPCA dataEntries, calculateAverage dataEntries)

compareIPCA :: IPCAData -> IPCAData -> Ordering
compareIPCA a b = compare (indexValue a) (indexValue b)

showIPCA :: IPCAData -> String
showIPCA dataEntry = indexValueStr ++ " (Year/Month: " ++ yearMonth dataEntry ++ ")"
    where indexValueStr = show (indexValue dataEntry)

calculateAverage :: [IPCAData] -> Double
calculateAverage dataEntries = sum (map indexValue dataEntries) / fromIntegral (length dataEntries)
