import Text.Read (readMaybe)

data Passenger = Passenger {
    hasRG :: Bool,
    birthDateRG :: String,
    hasTicket :: Bool,
    birthDateTicket :: String,
    seat :: String
} deriving (Show)

main :: IO ()
main = do
    putStrLn "Enter the number of passengers:"
    n <- readLn :: IO Int
    passengers <- getPassengers n
    mapM_ processPassenger passengers

getPassengers :: Int -> IO [Passenger]
getPassengers n = sequence $ replicate n getPassenger

getPassenger :: IO Passenger
getPassenger = do
    putStrLn "Does the passenger have an RG? (RG/No RG):"
    hasRGInput <- getLine
    let hasRG = hasRGInput == "RG"

    putStrLn "Enter the birth date on the RG (DD/MM/YYYY):"
    birthDateRG <- getLine

    putStrLn "Does the passenger have a ticket? (Ticket/No Ticket):"
    hasTicketInput <- getLine
    let hasTicket = hasTicketInput == "Ticket"

    putStrLn "Enter the birth date on the ticket (DD/MM/YYYY):"
    birthDateTicket <- getLine

    putStrLn "Enter the passenger's seat (e.g., A12):"
    seat <- getLine

    return $ Passenger hasRG birthDateRG hasTicket birthDateTicket seat

processPassenger :: Passenger -> IO ()
processPassenger passenger
    | not (hasRG passenger) = putStrLn "Head towards the exit."
    | not (hasTicket passenger) = putStrLn "Head to the reception."
    | birthDateRG passenger /= birthDateTicket passenger = putStrLn "190"
    | otherwise = putStrLn $ "Your seat is " ++ seat passenger ++ ". Have a great day."
