USE [master]
GO
/****** Object:  Database [CadastroCliente]    Script Date: 25/06/2018 14:32:09 ******/
CREATE DATABASE [CadastroCliente]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'CadastroCliente', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\CadastroCliente.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'CadastroCliente_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\CadastroCliente_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [CadastroCliente] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [CadastroCliente].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [CadastroCliente] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [CadastroCliente] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [CadastroCliente] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [CadastroCliente] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [CadastroCliente] SET ARITHABORT OFF 
GO
ALTER DATABASE [CadastroCliente] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [CadastroCliente] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [CadastroCliente] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [CadastroCliente] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [CadastroCliente] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [CadastroCliente] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [CadastroCliente] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [CadastroCliente] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [CadastroCliente] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [CadastroCliente] SET  DISABLE_BROKER 
GO
ALTER DATABASE [CadastroCliente] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [CadastroCliente] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [CadastroCliente] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [CadastroCliente] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [CadastroCliente] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [CadastroCliente] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [CadastroCliente] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [CadastroCliente] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [CadastroCliente] SET  MULTI_USER 
GO
ALTER DATABASE [CadastroCliente] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [CadastroCliente] SET DB_CHAINING OFF 
GO
ALTER DATABASE [CadastroCliente] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [CadastroCliente] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [CadastroCliente] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [CadastroCliente] SET QUERY_STORE = OFF
GO
USE [CadastroCliente]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [CadastroCliente]
GO
/****** Object:  User [Leticia]    Script Date: 25/06/2018 14:32:09 ******/
CREATE USER [Leticia] FOR LOGIN [Leticia] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [Administrador]    Script Date: 25/06/2018 14:32:09 ******/
CREATE USER [Administrador] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [Leticia]
GO
ALTER ROLE [db_owner] ADD MEMBER [Administrador]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 25/06/2018 14:32:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Nome] [varchar](max) NOT NULL,
	[Tel_Residencial] [varchar](max) NOT NULL,
	[Tel_Comercial] [varchar](max) NOT NULL,
	[Tel_Celular] [varchar](max) NOT NULL,
	[Email] [varchar](max) NOT NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [CadastroCliente] SET  READ_WRITE 
GO
