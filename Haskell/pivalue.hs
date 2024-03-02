module Main where

calculatePi :: Int -> Double
calculatePi n = let
    resultSeries = sum [term i | i <- [0..n-1]]
    term i = (-1) ** fromIntegral i * (1.0 / (2 * fromIntegral i + 1) ** 3)
    approximatedPi = (resultSeries * 32) ** (1.0 / 3)
    in approximatedPi

main :: IO ()
main = do
    putStr "Enter the number of terms to calculate pi: "
    n <- readLn
    let piValue = calculatePi n
    putStrLn $ "Approximate pi value with " ++ show n ++ " terms: " ++ show piValue
