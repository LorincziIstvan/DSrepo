CREATE TABLE [dbo].[Usr]
(
	[Id] INT  IDENTITY (1, 1) NOT NULL PRIMARY KEY, 
    [username] VARCHAR(50) NULL, 
    [password] VARCHAR(50) NULL, 
    [displayname] VARCHAR(50) NULL, 
    [address] VARCHAR(50) NULL, 
    [x] REAL NULL, 
    [y] REAL NULL, 
    [birthdate] DATE NULL, 
    [role] VARCHAR(50) NULL
)
