// Code generated from Lang.g4 by ANTLR 4.7.1. DO NOT EDIT.

package parser // Lang

import (
	"fmt"
	"reflect"
	"strconv"

	"github.com/antlr/antlr4/runtime/Go/antlr"
)

// Suppress unused import errors
var _ = fmt.Printf
var _ = reflect.Copy
var _ = strconv.Itoa

var parserATN = []uint16{
	3, 24715, 42794, 33075, 47597, 16764, 15335, 30598, 22884, 3, 66, 269,
	4, 2, 9, 2, 4, 3, 9, 3, 4, 4, 9, 4, 4, 5, 9, 5, 4, 6, 9, 6, 4, 7, 9, 7,
	4, 8, 9, 8, 4, 9, 9, 9, 4, 10, 9, 10, 4, 11, 9, 11, 4, 12, 9, 12, 4, 13,
	9, 13, 4, 14, 9, 14, 4, 15, 9, 15, 4, 16, 9, 16, 3, 2, 7, 2, 34, 10, 2,
	12, 2, 14, 2, 37, 11, 2, 3, 2, 3, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 3, 56, 10, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
	3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 7, 3, 112, 10, 3, 12, 3, 14, 3, 115,
	11, 3, 3, 4, 3, 4, 3, 4, 7, 4, 120, 10, 4, 12, 4, 14, 4, 123, 11, 4, 3,
	4, 5, 4, 126, 10, 4, 3, 5, 3, 5, 7, 5, 130, 10, 5, 12, 5, 14, 5, 133, 11,
	5, 3, 5, 3, 5, 3, 6, 3, 6, 5, 6, 139, 10, 6, 3, 6, 3, 6, 5, 6, 143, 10,
	6, 3, 6, 5, 6, 146, 10, 6, 3, 7, 3, 7, 3, 7, 3, 7, 3, 8, 3, 8, 3, 8, 3,
	8, 5, 8, 156, 10, 8, 3, 9, 3, 9, 3, 9, 7, 9, 161, 10, 9, 12, 9, 14, 9,
	164, 11, 9, 3, 9, 5, 9, 167, 10, 9, 3, 10, 3, 10, 3, 10, 3, 10, 5, 10,
	173, 10, 10, 3, 10, 3, 10, 5, 10, 177, 10, 10, 3, 11, 3, 11, 3, 11, 3,
	12, 3, 12, 3, 12, 3, 12, 3, 13, 3, 13, 3, 13, 3, 13, 5, 13, 190, 10, 13,
	3, 13, 3, 13, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3,
	14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14,
	3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3,
	14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14,
	3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3, 14, 3,
	14, 3, 14, 3, 14, 5, 14, 247, 10, 14, 3, 15, 3, 15, 3, 15, 3, 15, 5, 15,
	253, 10, 15, 3, 16, 3, 16, 3, 16, 3, 16, 7, 16, 259, 10, 16, 12, 16, 14,
	16, 262, 11, 16, 3, 16, 5, 16, 265, 10, 16, 3, 16, 3, 16, 3, 16, 2, 3,
	4, 17, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 2, 12, 3,
	2, 27, 28, 3, 2, 48, 49, 3, 2, 30, 31, 3, 2, 32, 34, 3, 2, 35, 36, 3, 2,
	37, 40, 3, 2, 41, 42, 3, 2, 50, 60, 3, 2, 12, 13, 3, 2, 15, 17, 2, 306,
	2, 35, 3, 2, 2, 2, 4, 55, 3, 2, 2, 2, 6, 121, 3, 2, 2, 2, 8, 127, 3, 2,
	2, 2, 10, 138, 3, 2, 2, 2, 12, 147, 3, 2, 2, 2, 14, 151, 3, 2, 2, 2, 16,
	162, 3, 2, 2, 2, 18, 172, 3, 2, 2, 2, 20, 178, 3, 2, 2, 2, 22, 181, 3,
	2, 2, 2, 24, 185, 3, 2, 2, 2, 26, 246, 3, 2, 2, 2, 28, 252, 3, 2, 2, 2,
	30, 254, 3, 2, 2, 2, 32, 34, 5, 26, 14, 2, 33, 32, 3, 2, 2, 2, 34, 37,
	3, 2, 2, 2, 35, 33, 3, 2, 2, 2, 35, 36, 3, 2, 2, 2, 36, 38, 3, 2, 2, 2,
	37, 35, 3, 2, 2, 2, 38, 39, 7, 2, 2, 3, 39, 3, 3, 2, 2, 2, 40, 41, 8, 3,
	1, 2, 41, 42, 7, 3, 2, 2, 42, 43, 5, 4, 3, 2, 43, 44, 7, 4, 2, 2, 44, 56,
	3, 2, 2, 2, 45, 56, 5, 20, 11, 2, 46, 47, 9, 2, 2, 2, 47, 56, 5, 4, 3,
	20, 48, 49, 9, 3, 2, 2, 49, 56, 5, 4, 3, 19, 50, 51, 9, 4, 2, 2, 51, 56,
	5, 4, 3, 18, 52, 56, 5, 14, 8, 2, 53, 56, 5, 28, 15, 2, 54, 56, 7, 62,
	2, 2, 55, 40, 3, 2, 2, 2, 55, 45, 3, 2, 2, 2, 55, 46, 3, 2, 2, 2, 55, 48,
	3, 2, 2, 2, 55, 50, 3, 2, 2, 2, 55, 52, 3, 2, 2, 2, 55, 53, 3, 2, 2, 2,
	55, 54, 3, 2, 2, 2, 56, 113, 3, 2, 2, 2, 57, 58, 12, 23, 2, 2, 58, 59,
	7, 29, 2, 2, 59, 112, 5, 4, 3, 24, 60, 61, 12, 17, 2, 2, 61, 62, 9, 5,
	2, 2, 62, 112, 5, 4, 3, 18, 63, 64, 12, 16, 2, 2, 64, 65, 9, 3, 2, 2, 65,
	112, 5, 4, 3, 17, 66, 67, 12, 15, 2, 2, 67, 68, 9, 6, 2, 2, 68, 112, 5,
	4, 3, 16, 69, 70, 12, 14, 2, 2, 70, 71, 9, 7, 2, 2, 71, 112, 5, 4, 3, 15,
	72, 73, 12, 13, 2, 2, 73, 74, 9, 8, 2, 2, 74, 112, 5, 4, 3, 14, 75, 76,
	12, 12, 2, 2, 76, 77, 7, 43, 2, 2, 77, 112, 5, 4, 3, 13, 78, 79, 12, 11,
	2, 2, 79, 80, 7, 44, 2, 2, 80, 112, 5, 4, 3, 12, 81, 82, 12, 10, 2, 2,
	82, 83, 7, 45, 2, 2, 83, 112, 5, 4, 3, 11, 84, 85, 12, 9, 2, 2, 85, 86,
	7, 46, 2, 2, 86, 112, 5, 4, 3, 10, 87, 88, 12, 8, 2, 2, 88, 89, 7, 47,
	2, 2, 89, 112, 5, 4, 3, 9, 90, 91, 12, 7, 2, 2, 91, 92, 7, 7, 2, 2, 92,
	93, 5, 4, 3, 2, 93, 94, 7, 8, 2, 2, 94, 95, 5, 4, 3, 8, 95, 112, 3, 2,
	2, 2, 96, 97, 12, 6, 2, 2, 97, 98, 9, 9, 2, 2, 98, 112, 5, 4, 3, 7, 99,
	100, 12, 25, 2, 2, 100, 101, 7, 3, 2, 2, 101, 102, 5, 6, 4, 2, 102, 103,
	7, 4, 2, 2, 103, 112, 3, 2, 2, 2, 104, 105, 12, 24, 2, 2, 105, 106, 7,
	5, 2, 2, 106, 107, 5, 4, 3, 2, 107, 108, 7, 6, 2, 2, 108, 112, 3, 2, 2,
	2, 109, 110, 12, 22, 2, 2, 110, 112, 9, 2, 2, 2, 111, 57, 3, 2, 2, 2, 111,
	60, 3, 2, 2, 2, 111, 63, 3, 2, 2, 2, 111, 66, 3, 2, 2, 2, 111, 69, 3, 2,
	2, 2, 111, 72, 3, 2, 2, 2, 111, 75, 3, 2, 2, 2, 111, 78, 3, 2, 2, 2, 111,
	81, 3, 2, 2, 2, 111, 84, 3, 2, 2, 2, 111, 87, 3, 2, 2, 2, 111, 90, 3, 2,
	2, 2, 111, 96, 3, 2, 2, 2, 111, 99, 3, 2, 2, 2, 111, 104, 3, 2, 2, 2, 111,
	109, 3, 2, 2, 2, 112, 115, 3, 2, 2, 2, 113, 111, 3, 2, 2, 2, 113, 114,
	3, 2, 2, 2, 114, 5, 3, 2, 2, 2, 115, 113, 3, 2, 2, 2, 116, 117, 5, 4, 3,
	2, 117, 118, 7, 9, 2, 2, 118, 120, 3, 2, 2, 2, 119, 116, 3, 2, 2, 2, 120,
	123, 3, 2, 2, 2, 121, 119, 3, 2, 2, 2, 121, 122, 3, 2, 2, 2, 122, 125,
	3, 2, 2, 2, 123, 121, 3, 2, 2, 2, 124, 126, 5, 4, 3, 2, 125, 124, 3, 2,
	2, 2, 125, 126, 3, 2, 2, 2, 126, 7, 3, 2, 2, 2, 127, 131, 7, 10, 2, 2,
	128, 130, 5, 26, 14, 2, 129, 128, 3, 2, 2, 2, 130, 133, 3, 2, 2, 2, 131,
	129, 3, 2, 2, 2, 131, 132, 3, 2, 2, 2, 132, 134, 3, 2, 2, 2, 133, 131,
	3, 2, 2, 2, 134, 135, 7, 11, 2, 2, 135, 9, 3, 2, 2, 2, 136, 139, 7, 62,
	2, 2, 137, 139, 5, 18, 10, 2, 138, 136, 3, 2, 2, 2, 138, 137, 3, 2, 2,
	2, 139, 145, 3, 2, 2, 2, 140, 142, 7, 5, 2, 2, 141, 143, 5, 28, 15, 2,
	142, 141, 3, 2, 2, 2, 142, 143, 3, 2, 2, 2, 143, 144, 3, 2, 2, 2, 144,
	146, 7, 6, 2, 2, 145, 140, 3, 2, 2, 2, 145, 146, 3, 2, 2, 2, 146, 11, 3,
	2, 2, 2, 147, 148, 7, 62, 2, 2, 148, 149, 7, 8, 2, 2, 149, 150, 5, 10,
	6, 2, 150, 13, 3, 2, 2, 2, 151, 152, 9, 10, 2, 2, 152, 155, 5, 12, 7, 2,
	153, 154, 7, 50, 2, 2, 154, 156, 5, 4, 3, 2, 155, 153, 3, 2, 2, 2, 155,
	156, 3, 2, 2, 2, 156, 15, 3, 2, 2, 2, 157, 158, 5, 12, 7, 2, 158, 159,
	7, 9, 2, 2, 159, 161, 3, 2, 2, 2, 160, 157, 3, 2, 2, 2, 161, 164, 3, 2,
	2, 2, 162, 160, 3, 2, 2, 2, 162, 163, 3, 2, 2, 2, 163, 166, 3, 2, 2, 2,
	164, 162, 3, 2, 2, 2, 165, 167, 5, 12, 7, 2, 166, 165, 3, 2, 2, 2, 166,
	167, 3, 2, 2, 2, 167, 17, 3, 2, 2, 2, 168, 169, 7, 3, 2, 2, 169, 170, 5,
	16, 9, 2, 170, 171, 7, 4, 2, 2, 171, 173, 3, 2, 2, 2, 172, 168, 3, 2, 2,
	2, 172, 173, 3, 2, 2, 2, 173, 176, 3, 2, 2, 2, 174, 175, 7, 8, 2, 2, 175,
	177, 5, 10, 6, 2, 176, 174, 3, 2, 2, 2, 176, 177, 3, 2, 2, 2, 177, 19,
	3, 2, 2, 2, 178, 179, 5, 18, 10, 2, 179, 180, 5, 8, 5, 2, 180, 21, 3, 2,
	2, 2, 181, 182, 7, 14, 2, 2, 182, 183, 7, 62, 2, 2, 183, 184, 5, 20, 11,
	2, 184, 23, 3, 2, 2, 2, 185, 186, 9, 11, 2, 2, 186, 189, 7, 62, 2, 2, 187,
	188, 7, 8, 2, 2, 188, 190, 7, 62, 2, 2, 189, 187, 3, 2, 2, 2, 189, 190,
	3, 2, 2, 2, 190, 191, 3, 2, 2, 2, 191, 192, 5, 8, 5, 2, 192, 25, 3, 2,
	2, 2, 193, 194, 7, 18, 2, 2, 194, 195, 7, 3, 2, 2, 195, 196, 5, 4, 3, 2,
	196, 197, 7, 4, 2, 2, 197, 198, 5, 8, 5, 2, 198, 247, 3, 2, 2, 2, 199,
	200, 7, 19, 2, 2, 200, 201, 7, 18, 2, 2, 201, 202, 7, 3, 2, 2, 202, 203,
	5, 4, 3, 2, 203, 204, 7, 4, 2, 2, 204, 205, 5, 8, 5, 2, 205, 247, 3, 2,
	2, 2, 206, 207, 7, 19, 2, 2, 207, 247, 5, 8, 5, 2, 208, 209, 7, 20, 2,
	2, 209, 210, 7, 3, 2, 2, 210, 211, 5, 4, 3, 2, 211, 212, 7, 4, 2, 2, 212,
	213, 5, 8, 5, 2, 213, 247, 3, 2, 2, 2, 214, 215, 7, 21, 2, 2, 215, 216,
	5, 8, 5, 2, 216, 217, 7, 20, 2, 2, 217, 218, 7, 3, 2, 2, 218, 219, 5, 4,
	3, 2, 219, 220, 7, 4, 2, 2, 220, 221, 7, 22, 2, 2, 221, 247, 3, 2, 2, 2,
	222, 223, 7, 23, 2, 2, 223, 224, 7, 3, 2, 2, 224, 225, 5, 4, 3, 2, 225,
	226, 7, 22, 2, 2, 226, 227, 5, 4, 3, 2, 227, 228, 7, 22, 2, 2, 228, 229,
	5, 4, 3, 2, 229, 230, 7, 4, 2, 2, 230, 231, 5, 8, 5, 2, 231, 247, 3, 2,
	2, 2, 232, 233, 7, 24, 2, 2, 233, 234, 5, 4, 3, 2, 234, 235, 7, 22, 2,
	2, 235, 247, 3, 2, 2, 2, 236, 237, 7, 25, 2, 2, 237, 247, 7, 22, 2, 2,
	238, 239, 7, 26, 2, 2, 239, 247, 7, 22, 2, 2, 240, 247, 5, 22, 12, 2, 241,
	247, 5, 24, 13, 2, 242, 243, 5, 4, 3, 2, 243, 244, 7, 22, 2, 2, 244, 247,
	3, 2, 2, 2, 245, 247, 5, 8, 5, 2, 246, 193, 3, 2, 2, 2, 246, 199, 3, 2,
	2, 2, 246, 206, 3, 2, 2, 2, 246, 208, 3, 2, 2, 2, 246, 214, 3, 2, 2, 2,
	246, 222, 3, 2, 2, 2, 246, 232, 3, 2, 2, 2, 246, 236, 3, 2, 2, 2, 246,
	238, 3, 2, 2, 2, 246, 240, 3, 2, 2, 2, 246, 241, 3, 2, 2, 2, 246, 242,
	3, 2, 2, 2, 246, 245, 3, 2, 2, 2, 247, 27, 3, 2, 2, 2, 248, 253, 7, 61,
	2, 2, 249, 253, 7, 63, 2, 2, 250, 253, 7, 64, 2, 2, 251, 253, 5, 30, 16,
	2, 252, 248, 3, 2, 2, 2, 252, 249, 3, 2, 2, 2, 252, 250, 3, 2, 2, 2, 252,
	251, 3, 2, 2, 2, 253, 29, 3, 2, 2, 2, 254, 260, 7, 5, 2, 2, 255, 256, 5,
	4, 3, 2, 256, 257, 7, 9, 2, 2, 257, 259, 3, 2, 2, 2, 258, 255, 3, 2, 2,
	2, 259, 262, 3, 2, 2, 2, 260, 258, 3, 2, 2, 2, 260, 261, 3, 2, 2, 2, 261,
	264, 3, 2, 2, 2, 262, 260, 3, 2, 2, 2, 263, 265, 5, 4, 3, 2, 264, 263,
	3, 2, 2, 2, 264, 265, 3, 2, 2, 2, 265, 266, 3, 2, 2, 2, 266, 267, 7, 6,
	2, 2, 267, 31, 3, 2, 2, 2, 22, 35, 55, 111, 113, 121, 125, 131, 138, 142,
	145, 155, 162, 166, 172, 176, 189, 246, 252, 260, 264,
}
var deserializer = antlr.NewATNDeserializer(nil)
var deserializedATN = deserializer.DeserializeFromUInt16(parserATN)

var literalNames = []string{
	"", "'('", "')'", "'['", "']'", "'?'", "':'", "','", "'{'", "'}'", "'var'",
	"'val'", "'fn'", "'class'", "'singelton'", "'struct'", "'if'", "'else'",
	"'while'", "'do'", "';'", "'for'", "'return'", "'continue'", "'break'",
	"'++'", "'--'", "'.'", "'!'", "'~'", "'*'", "'/'", "'%'", "'<<'", "'>>'",
	"'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&'", "'|'", "'^'", "'&&'",
	"'||'", "'+'", "'-'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'<<='",
	"'>>='", "'&='", "'^='", "'|='",
}
var symbolicNames = []string{
	"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
	"", "", "", "", "", "", "", "OP_INC", "OP_DEC", "OP_DOT", "OP_LNOT", "OP_BNOT",
	"OP_MUL", "OP_DIV", "OP_MOD", "OP_LSH", "OP_RSH", "OP_LT", "OP_LTE", "OP_GT",
	"OP_GTE", "OP_EQ", "OP_NEQ", "OP_BAND", "OP_BOR", "OP_BXOR", "OP_LAND",
	"OP_LOR", "OP_ADD", "OP_SUB", "OP_ASG", "OP_ADD_ASG", "OP_SUB_ASG", "OP_MUL_ASG",
	"OP_DIV_ASG", "OP_MOD_ASG", "OP_LSH_ASG", "OP_RSH_ASG", "OP_BAND_ASG",
	"OP_BXOR_ASG", "OP_BOR_ASG", "NUM", "ID", "STR", "CHR", "WS", "COMMENT",
}

var ruleNames = []string{
	"program", "expr", "funcArgsExpr", "block", "typeDecl", "varType", "varDecl",
	"funcArgDecl", "funcType", "funcBody", "funcDecl", "classDecl", "statment",
	"literal", "arrayLiteral",
}
var decisionToDFA = make([]*antlr.DFA, len(deserializedATN.DecisionToState))

func init() {
	for index, ds := range deserializedATN.DecisionToState {
		decisionToDFA[index] = antlr.NewDFA(ds, index)
	}
}

type LangParser struct {
	*antlr.BaseParser
}

func NewLangParser(input antlr.TokenStream) *LangParser {
	this := new(LangParser)

	this.BaseParser = antlr.NewBaseParser(input)

	this.Interpreter = antlr.NewParserATNSimulator(this, deserializedATN, decisionToDFA, antlr.NewPredictionContextCache())
	this.RuleNames = ruleNames
	this.LiteralNames = literalNames
	this.SymbolicNames = symbolicNames
	this.GrammarFileName = "Lang.g4"

	return this
}

// LangParser tokens.
const (
	LangParserEOF         = antlr.TokenEOF
	LangParserT__0        = 1
	LangParserT__1        = 2
	LangParserT__2        = 3
	LangParserT__3        = 4
	LangParserT__4        = 5
	LangParserT__5        = 6
	LangParserT__6        = 7
	LangParserT__7        = 8
	LangParserT__8        = 9
	LangParserT__9        = 10
	LangParserT__10       = 11
	LangParserT__11       = 12
	LangParserT__12       = 13
	LangParserT__13       = 14
	LangParserT__14       = 15
	LangParserT__15       = 16
	LangParserT__16       = 17
	LangParserT__17       = 18
	LangParserT__18       = 19
	LangParserT__19       = 20
	LangParserT__20       = 21
	LangParserT__21       = 22
	LangParserT__22       = 23
	LangParserT__23       = 24
	LangParserOP_INC      = 25
	LangParserOP_DEC      = 26
	LangParserOP_DOT      = 27
	LangParserOP_LNOT     = 28
	LangParserOP_BNOT     = 29
	LangParserOP_MUL      = 30
	LangParserOP_DIV      = 31
	LangParserOP_MOD      = 32
	LangParserOP_LSH      = 33
	LangParserOP_RSH      = 34
	LangParserOP_LT       = 35
	LangParserOP_LTE      = 36
	LangParserOP_GT       = 37
	LangParserOP_GTE      = 38
	LangParserOP_EQ       = 39
	LangParserOP_NEQ      = 40
	LangParserOP_BAND     = 41
	LangParserOP_BOR      = 42
	LangParserOP_BXOR     = 43
	LangParserOP_LAND     = 44
	LangParserOP_LOR      = 45
	LangParserOP_ADD      = 46
	LangParserOP_SUB      = 47
	LangParserOP_ASG      = 48
	LangParserOP_ADD_ASG  = 49
	LangParserOP_SUB_ASG  = 50
	LangParserOP_MUL_ASG  = 51
	LangParserOP_DIV_ASG  = 52
	LangParserOP_MOD_ASG  = 53
	LangParserOP_LSH_ASG  = 54
	LangParserOP_RSH_ASG  = 55
	LangParserOP_BAND_ASG = 56
	LangParserOP_BXOR_ASG = 57
	LangParserOP_BOR_ASG  = 58
	LangParserNUM         = 59
	LangParserID          = 60
	LangParserSTR         = 61
	LangParserCHR         = 62
	LangParserWS          = 63
	LangParserCOMMENT     = 64
)

// LangParser rules.
const (
	LangParserRULE_program      = 0
	LangParserRULE_expr         = 1
	LangParserRULE_funcArgsExpr = 2
	LangParserRULE_block        = 3
	LangParserRULE_typeDecl     = 4
	LangParserRULE_varType      = 5
	LangParserRULE_varDecl      = 6
	LangParserRULE_funcArgDecl  = 7
	LangParserRULE_funcType     = 8
	LangParserRULE_funcBody     = 9
	LangParserRULE_funcDecl     = 10
	LangParserRULE_classDecl    = 11
	LangParserRULE_statment     = 12
	LangParserRULE_literal      = 13
	LangParserRULE_arrayLiteral = 14
)

// IProgramContext is an interface to support dynamic dispatch.
type IProgramContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// IsProgramContext differentiates from other interfaces.
	IsProgramContext()
}

type ProgramContext struct {
	*antlr.BaseParserRuleContext
	parser antlr.Parser
}

func NewEmptyProgramContext() *ProgramContext {
	var p = new(ProgramContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_program
	return p
}

func (*ProgramContext) IsProgramContext() {}

func NewProgramContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *ProgramContext {
	var p = new(ProgramContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_program

	return p
}

func (s *ProgramContext) GetParser() antlr.Parser { return s.parser }

func (s *ProgramContext) EOF() antlr.TerminalNode {
	return s.GetToken(LangParserEOF, 0)
}

func (s *ProgramContext) AllStatment() []IStatmentContext {
	var ts = s.GetTypedRuleContexts(reflect.TypeOf((*IStatmentContext)(nil)).Elem())
	var tst = make([]IStatmentContext, len(ts))

	for i, t := range ts {
		if t != nil {
			tst[i] = t.(IStatmentContext)
		}
	}

	return tst
}

func (s *ProgramContext) Statment(i int) IStatmentContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IStatmentContext)(nil)).Elem(), i)

	if t == nil {
		return nil
	}

	return t.(IStatmentContext)
}

func (s *ProgramContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ProgramContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *ProgramContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterProgram(s)
	}
}

func (s *ProgramContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitProgram(s)
	}
}

func (p *LangParser) Program() (localctx IProgramContext) {
	localctx = NewProgramContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 0, LangParserRULE_program)
	var _la int

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	p.EnterOuterAlt(localctx, 1)
	p.SetState(33)
	p.GetErrorHandler().Sync(p)
	_la = p.GetTokenStream().LA(1)

	for (((_la)&-(0x1f+1)) == 0 && ((1<<uint(_la))&((1<<LangParserT__0)|(1<<LangParserT__2)|(1<<LangParserT__5)|(1<<LangParserT__7)|(1<<LangParserT__9)|(1<<LangParserT__10)|(1<<LangParserT__11)|(1<<LangParserT__12)|(1<<LangParserT__13)|(1<<LangParserT__14)|(1<<LangParserT__15)|(1<<LangParserT__16)|(1<<LangParserT__17)|(1<<LangParserT__18)|(1<<LangParserT__20)|(1<<LangParserT__21)|(1<<LangParserT__22)|(1<<LangParserT__23)|(1<<LangParserOP_INC)|(1<<LangParserOP_DEC)|(1<<LangParserOP_LNOT)|(1<<LangParserOP_BNOT))) != 0) || (((_la-46)&-(0x1f+1)) == 0 && ((1<<uint((_la-46)))&((1<<(LangParserOP_ADD-46))|(1<<(LangParserOP_SUB-46))|(1<<(LangParserNUM-46))|(1<<(LangParserID-46))|(1<<(LangParserSTR-46))|(1<<(LangParserCHR-46)))) != 0) {
		{
			p.SetState(30)
			p.Statment()
		}

		p.SetState(35)
		p.GetErrorHandler().Sync(p)
		_la = p.GetTokenStream().LA(1)
	}
	{
		p.SetState(36)
		p.Match(LangParserEOF)
	}

	return localctx
}

// IExprContext is an interface to support dynamic dispatch.
type IExprContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// IsExprContext differentiates from other interfaces.
	IsExprContext()
}

type ExprContext struct {
	*antlr.BaseParserRuleContext
	parser antlr.Parser
}

func NewEmptyExprContext() *ExprContext {
	var p = new(ExprContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_expr
	return p
}

func (*ExprContext) IsExprContext() {}

func NewExprContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *ExprContext {
	var p = new(ExprContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_expr

	return p
}

func (s *ExprContext) GetParser() antlr.Parser { return s.parser }

func (s *ExprContext) CopyFrom(ctx *ExprContext) {
	s.BaseParserRuleContext.CopyFrom(ctx.BaseParserRuleContext)
}

func (s *ExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ExprContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

type AssignmentExprContext struct {
	*ExprContext
	left  IExprContext
	op    antlr.Token
	right IExprContext
}

func NewAssignmentExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *AssignmentExprContext {
	var p = new(AssignmentExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *AssignmentExprContext) GetOp() antlr.Token { return s.op }

func (s *AssignmentExprContext) SetOp(v antlr.Token) { s.op = v }

func (s *AssignmentExprContext) GetLeft() IExprContext { return s.left }

func (s *AssignmentExprContext) GetRight() IExprContext { return s.right }

func (s *AssignmentExprContext) SetLeft(v IExprContext) { s.left = v }

func (s *AssignmentExprContext) SetRight(v IExprContext) { s.right = v }

func (s *AssignmentExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *AssignmentExprContext) AllExpr() []IExprContext {
	var ts = s.GetTypedRuleContexts(reflect.TypeOf((*IExprContext)(nil)).Elem())
	var tst = make([]IExprContext, len(ts))

	for i, t := range ts {
		if t != nil {
			tst[i] = t.(IExprContext)
		}
	}

	return tst
}

func (s *AssignmentExprContext) Expr(i int) IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), i)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *AssignmentExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterAssignmentExpr(s)
	}
}

func (s *AssignmentExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitAssignmentExpr(s)
	}
}

type DotExprContext struct {
	*ExprContext
	varName IExprContext
	sub     IExprContext
}

func NewDotExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *DotExprContext {
	var p = new(DotExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *DotExprContext) GetVarName() IExprContext { return s.varName }

func (s *DotExprContext) GetSub() IExprContext { return s.sub }

func (s *DotExprContext) SetVarName(v IExprContext) { s.varName = v }

func (s *DotExprContext) SetSub(v IExprContext) { s.sub = v }

func (s *DotExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *DotExprContext) AllExpr() []IExprContext {
	var ts = s.GetTypedRuleContexts(reflect.TypeOf((*IExprContext)(nil)).Elem())
	var tst = make([]IExprContext, len(ts))

	for i, t := range ts {
		if t != nil {
			tst[i] = t.(IExprContext)
		}
	}

	return tst
}

func (s *DotExprContext) Expr(i int) IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), i)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *DotExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterDotExpr(s)
	}
}

func (s *DotExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitDotExpr(s)
	}
}

type FuncExprContext struct {
	*ExprContext
	name IExprContext
	args IFuncArgsExprContext
}

func NewFuncExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *FuncExprContext {
	var p = new(FuncExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *FuncExprContext) GetName() IExprContext { return s.name }

func (s *FuncExprContext) GetArgs() IFuncArgsExprContext { return s.args }

func (s *FuncExprContext) SetName(v IExprContext) { s.name = v }

func (s *FuncExprContext) SetArgs(v IFuncArgsExprContext) { s.args = v }

func (s *FuncExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *FuncExprContext) Expr() IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *FuncExprContext) FuncArgsExpr() IFuncArgsExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IFuncArgsExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IFuncArgsExprContext)
}

func (s *FuncExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterFuncExpr(s)
	}
}

func (s *FuncExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitFuncExpr(s)
	}
}

type ArrayExprContext struct {
	*ExprContext
	varName IExprContext
	sub     IExprContext
}

func NewArrayExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *ArrayExprContext {
	var p = new(ArrayExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *ArrayExprContext) GetVarName() IExprContext { return s.varName }

func (s *ArrayExprContext) GetSub() IExprContext { return s.sub }

func (s *ArrayExprContext) SetVarName(v IExprContext) { s.varName = v }

func (s *ArrayExprContext) SetSub(v IExprContext) { s.sub = v }

func (s *ArrayExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ArrayExprContext) AllExpr() []IExprContext {
	var ts = s.GetTypedRuleContexts(reflect.TypeOf((*IExprContext)(nil)).Elem())
	var tst = make([]IExprContext, len(ts))

	for i, t := range ts {
		if t != nil {
			tst[i] = t.(IExprContext)
		}
	}

	return tst
}

func (s *ArrayExprContext) Expr(i int) IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), i)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *ArrayExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterArrayExpr(s)
	}
}

func (s *ArrayExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitArrayExpr(s)
	}
}

type ParenExprContext struct {
	*ExprContext
}

func NewParenExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *ParenExprContext {
	var p = new(ParenExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *ParenExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ParenExprContext) Expr() IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *ParenExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterParenExpr(s)
	}
}

func (s *ParenExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitParenExpr(s)
	}
}

type PrefixExprContext struct {
	*ExprContext
	op      antlr.Token
	varName IExprContext
}

func NewPrefixExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *PrefixExprContext {
	var p = new(PrefixExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *PrefixExprContext) GetOp() antlr.Token { return s.op }

func (s *PrefixExprContext) SetOp(v antlr.Token) { s.op = v }

func (s *PrefixExprContext) GetVarName() IExprContext { return s.varName }

func (s *PrefixExprContext) SetVarName(v IExprContext) { s.varName = v }

func (s *PrefixExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *PrefixExprContext) Expr() IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *PrefixExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterPrefixExpr(s)
	}
}

func (s *PrefixExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitPrefixExpr(s)
	}
}

type DeclExprContext struct {
	*ExprContext
	decl IVarDeclContext
}

func NewDeclExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *DeclExprContext {
	var p = new(DeclExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *DeclExprContext) GetDecl() IVarDeclContext { return s.decl }

func (s *DeclExprContext) SetDecl(v IVarDeclContext) { s.decl = v }

func (s *DeclExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *DeclExprContext) VarDecl() IVarDeclContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IVarDeclContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IVarDeclContext)
}

func (s *DeclExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterDeclExpr(s)
	}
}

func (s *DeclExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitDeclExpr(s)
	}
}

type InfixExprContext struct {
	*ExprContext
	left  IExprContext
	op    antlr.Token
	right IExprContext
}

func NewInfixExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *InfixExprContext {
	var p = new(InfixExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *InfixExprContext) GetOp() antlr.Token { return s.op }

func (s *InfixExprContext) SetOp(v antlr.Token) { s.op = v }

func (s *InfixExprContext) GetLeft() IExprContext { return s.left }

func (s *InfixExprContext) GetRight() IExprContext { return s.right }

func (s *InfixExprContext) SetLeft(v IExprContext) { s.left = v }

func (s *InfixExprContext) SetRight(v IExprContext) { s.right = v }

func (s *InfixExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *InfixExprContext) AllExpr() []IExprContext {
	var ts = s.GetTypedRuleContexts(reflect.TypeOf((*IExprContext)(nil)).Elem())
	var tst = make([]IExprContext, len(ts))

	for i, t := range ts {
		if t != nil {
			tst[i] = t.(IExprContext)
		}
	}

	return tst
}

func (s *InfixExprContext) Expr(i int) IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), i)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *InfixExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterInfixExpr(s)
	}
}

func (s *InfixExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitInfixExpr(s)
	}
}

type TernaryExprContext struct {
	*ExprContext
	cond  IExprContext
	left  IExprContext
	right IExprContext
}

func NewTernaryExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *TernaryExprContext {
	var p = new(TernaryExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *TernaryExprContext) GetCond() IExprContext { return s.cond }

func (s *TernaryExprContext) GetLeft() IExprContext { return s.left }

func (s *TernaryExprContext) GetRight() IExprContext { return s.right }

func (s *TernaryExprContext) SetCond(v IExprContext) { s.cond = v }

func (s *TernaryExprContext) SetLeft(v IExprContext) { s.left = v }

func (s *TernaryExprContext) SetRight(v IExprContext) { s.right = v }

func (s *TernaryExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *TernaryExprContext) AllExpr() []IExprContext {
	var ts = s.GetTypedRuleContexts(reflect.TypeOf((*IExprContext)(nil)).Elem())
	var tst = make([]IExprContext, len(ts))

	for i, t := range ts {
		if t != nil {
			tst[i] = t.(IExprContext)
		}
	}

	return tst
}

func (s *TernaryExprContext) Expr(i int) IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), i)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *TernaryExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterTernaryExpr(s)
	}
}

func (s *TernaryExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitTernaryExpr(s)
	}
}

type LambdaExprContext struct {
	*ExprContext
	varName IFuncBodyContext
}

func NewLambdaExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *LambdaExprContext {
	var p = new(LambdaExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *LambdaExprContext) GetVarName() IFuncBodyContext { return s.varName }

func (s *LambdaExprContext) SetVarName(v IFuncBodyContext) { s.varName = v }

func (s *LambdaExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *LambdaExprContext) FuncBody() IFuncBodyContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IFuncBodyContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IFuncBodyContext)
}

func (s *LambdaExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterLambdaExpr(s)
	}
}

func (s *LambdaExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitLambdaExpr(s)
	}
}

type LiteralExprContext struct {
	*ExprContext
}

func NewLiteralExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *LiteralExprContext {
	var p = new(LiteralExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *LiteralExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *LiteralExprContext) Literal() ILiteralContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*ILiteralContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(ILiteralContext)
}

func (s *LiteralExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterLiteralExpr(s)
	}
}

func (s *LiteralExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitLiteralExpr(s)
	}
}

type PostfixExprContext struct {
	*ExprContext
	varName IExprContext
}

func NewPostfixExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *PostfixExprContext {
	var p = new(PostfixExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *PostfixExprContext) GetVarName() IExprContext { return s.varName }

func (s *PostfixExprContext) SetVarName(v IExprContext) { s.varName = v }

func (s *PostfixExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *PostfixExprContext) Expr() IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *PostfixExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterPostfixExpr(s)
	}
}

func (s *PostfixExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitPostfixExpr(s)
	}
}

type IdExprContext struct {
	*ExprContext
}

func NewIdExprContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *IdExprContext {
	var p = new(IdExprContext)

	p.ExprContext = NewEmptyExprContext()
	p.parser = parser
	p.CopyFrom(ctx.(*ExprContext))

	return p
}

func (s *IdExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *IdExprContext) ID() antlr.TerminalNode {
	return s.GetToken(LangParserID, 0)
}

func (s *IdExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterIdExpr(s)
	}
}

func (s *IdExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitIdExpr(s)
	}
}

func (p *LangParser) Expr() (localctx IExprContext) {
	return p.expr(0)
}

func (p *LangParser) expr(_p int) (localctx IExprContext) {
	var _parentctx antlr.ParserRuleContext = p.GetParserRuleContext()
	_parentState := p.GetState()
	localctx = NewExprContext(p, p.GetParserRuleContext(), _parentState)
	var _prevctx IExprContext = localctx
	var _ antlr.ParserRuleContext = _prevctx // TODO: To prevent unused variable warning.
	_startState := 2
	p.EnterRecursionRule(localctx, 2, LangParserRULE_expr, _p)
	var _la int

	defer func() {
		p.UnrollRecursionContexts(_parentctx)
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	var _alt int

	p.EnterOuterAlt(localctx, 1)
	p.SetState(53)
	p.GetErrorHandler().Sync(p)
	switch p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 1, p.GetParserRuleContext()) {
	case 1:
		localctx = NewParenExprContext(p, localctx)
		p.SetParserRuleContext(localctx)
		_prevctx = localctx

		{
			p.SetState(39)
			p.Match(LangParserT__0)
		}
		{
			p.SetState(40)
			p.expr(0)
		}
		{
			p.SetState(41)
			p.Match(LangParserT__1)
		}

	case 2:
		localctx = NewLambdaExprContext(p, localctx)
		p.SetParserRuleContext(localctx)
		_prevctx = localctx
		{
			p.SetState(43)

			var _x = p.FuncBody()

			localctx.(*LambdaExprContext).varName = _x
		}

	case 3:
		localctx = NewPrefixExprContext(p, localctx)
		p.SetParserRuleContext(localctx)
		_prevctx = localctx
		{
			p.SetState(44)

			var _lt = p.GetTokenStream().LT(1)

			localctx.(*PrefixExprContext).op = _lt

			_la = p.GetTokenStream().LA(1)

			if !(_la == LangParserOP_INC || _la == LangParserOP_DEC) {
				var _ri = p.GetErrorHandler().RecoverInline(p)

				localctx.(*PrefixExprContext).op = _ri
			} else {
				p.GetErrorHandler().ReportMatch(p)
				p.Consume()
			}
		}
		{
			p.SetState(45)

			var _x = p.expr(18)

			localctx.(*PrefixExprContext).varName = _x
		}

	case 4:
		localctx = NewPrefixExprContext(p, localctx)
		p.SetParserRuleContext(localctx)
		_prevctx = localctx
		{
			p.SetState(46)

			var _lt = p.GetTokenStream().LT(1)

			localctx.(*PrefixExprContext).op = _lt

			_la = p.GetTokenStream().LA(1)

			if !(_la == LangParserOP_ADD || _la == LangParserOP_SUB) {
				var _ri = p.GetErrorHandler().RecoverInline(p)

				localctx.(*PrefixExprContext).op = _ri
			} else {
				p.GetErrorHandler().ReportMatch(p)
				p.Consume()
			}
		}
		{
			p.SetState(47)

			var _x = p.expr(17)

			localctx.(*PrefixExprContext).varName = _x
		}

	case 5:
		localctx = NewPrefixExprContext(p, localctx)
		p.SetParserRuleContext(localctx)
		_prevctx = localctx
		{
			p.SetState(48)

			var _lt = p.GetTokenStream().LT(1)

			localctx.(*PrefixExprContext).op = _lt

			_la = p.GetTokenStream().LA(1)

			if !(_la == LangParserOP_LNOT || _la == LangParserOP_BNOT) {
				var _ri = p.GetErrorHandler().RecoverInline(p)

				localctx.(*PrefixExprContext).op = _ri
			} else {
				p.GetErrorHandler().ReportMatch(p)
				p.Consume()
			}
		}
		{
			p.SetState(49)

			var _x = p.expr(16)

			localctx.(*PrefixExprContext).varName = _x
		}

	case 6:
		localctx = NewDeclExprContext(p, localctx)
		p.SetParserRuleContext(localctx)
		_prevctx = localctx
		{
			p.SetState(50)

			var _x = p.VarDecl()

			localctx.(*DeclExprContext).decl = _x
		}

	case 7:
		localctx = NewLiteralExprContext(p, localctx)
		p.SetParserRuleContext(localctx)
		_prevctx = localctx
		{
			p.SetState(51)
			p.Literal()
		}

	case 8:
		localctx = NewIdExprContext(p, localctx)
		p.SetParserRuleContext(localctx)
		_prevctx = localctx
		{
			p.SetState(52)
			p.Match(LangParserID)
		}

	}
	p.GetParserRuleContext().SetStop(p.GetTokenStream().LT(-1))
	p.SetState(111)
	p.GetErrorHandler().Sync(p)
	_alt = p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 3, p.GetParserRuleContext())

	for _alt != 2 && _alt != antlr.ATNInvalidAltNumber {
		if _alt == 1 {
			if p.GetParseListeners() != nil {
				p.TriggerExitRuleEvent()
			}
			_prevctx = localctx
			p.SetState(109)
			p.GetErrorHandler().Sync(p)
			switch p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 2, p.GetParserRuleContext()) {
			case 1:
				localctx = NewDotExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*DotExprContext).varName = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(55)

				if !(p.Precpred(p.GetParserRuleContext(), 21)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 21)", ""))
				}
				{
					p.SetState(56)
					p.Match(LangParserOP_DOT)
				}
				{
					p.SetState(57)

					var _x = p.expr(22)

					localctx.(*DotExprContext).sub = _x
				}

			case 2:
				localctx = NewInfixExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*InfixExprContext).left = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(58)

				if !(p.Precpred(p.GetParserRuleContext(), 15)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 15)", ""))
				}
				{
					p.SetState(59)

					var _lt = p.GetTokenStream().LT(1)

					localctx.(*InfixExprContext).op = _lt

					_la = p.GetTokenStream().LA(1)

					if !(((_la-30)&-(0x1f+1)) == 0 && ((1<<uint((_la-30)))&((1<<(LangParserOP_MUL-30))|(1<<(LangParserOP_DIV-30))|(1<<(LangParserOP_MOD-30)))) != 0) {
						var _ri = p.GetErrorHandler().RecoverInline(p)

						localctx.(*InfixExprContext).op = _ri
					} else {
						p.GetErrorHandler().ReportMatch(p)
						p.Consume()
					}
				}
				{
					p.SetState(60)

					var _x = p.expr(16)

					localctx.(*InfixExprContext).right = _x
				}

			case 3:
				localctx = NewInfixExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*InfixExprContext).left = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(61)

				if !(p.Precpred(p.GetParserRuleContext(), 14)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 14)", ""))
				}
				{
					p.SetState(62)

					var _lt = p.GetTokenStream().LT(1)

					localctx.(*InfixExprContext).op = _lt

					_la = p.GetTokenStream().LA(1)

					if !(_la == LangParserOP_ADD || _la == LangParserOP_SUB) {
						var _ri = p.GetErrorHandler().RecoverInline(p)

						localctx.(*InfixExprContext).op = _ri
					} else {
						p.GetErrorHandler().ReportMatch(p)
						p.Consume()
					}
				}
				{
					p.SetState(63)

					var _x = p.expr(15)

					localctx.(*InfixExprContext).right = _x
				}

			case 4:
				localctx = NewInfixExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*InfixExprContext).left = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(64)

				if !(p.Precpred(p.GetParserRuleContext(), 13)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 13)", ""))
				}
				{
					p.SetState(65)

					var _lt = p.GetTokenStream().LT(1)

					localctx.(*InfixExprContext).op = _lt

					_la = p.GetTokenStream().LA(1)

					if !(_la == LangParserOP_LSH || _la == LangParserOP_RSH) {
						var _ri = p.GetErrorHandler().RecoverInline(p)

						localctx.(*InfixExprContext).op = _ri
					} else {
						p.GetErrorHandler().ReportMatch(p)
						p.Consume()
					}
				}
				{
					p.SetState(66)

					var _x = p.expr(14)

					localctx.(*InfixExprContext).right = _x
				}

			case 5:
				localctx = NewInfixExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*InfixExprContext).left = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(67)

				if !(p.Precpred(p.GetParserRuleContext(), 12)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 12)", ""))
				}
				{
					p.SetState(68)

					var _lt = p.GetTokenStream().LT(1)

					localctx.(*InfixExprContext).op = _lt

					_la = p.GetTokenStream().LA(1)

					if !(((_la-35)&-(0x1f+1)) == 0 && ((1<<uint((_la-35)))&((1<<(LangParserOP_LT-35))|(1<<(LangParserOP_LTE-35))|(1<<(LangParserOP_GT-35))|(1<<(LangParserOP_GTE-35)))) != 0) {
						var _ri = p.GetErrorHandler().RecoverInline(p)

						localctx.(*InfixExprContext).op = _ri
					} else {
						p.GetErrorHandler().ReportMatch(p)
						p.Consume()
					}
				}
				{
					p.SetState(69)

					var _x = p.expr(13)

					localctx.(*InfixExprContext).right = _x
				}

			case 6:
				localctx = NewInfixExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*InfixExprContext).left = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(70)

				if !(p.Precpred(p.GetParserRuleContext(), 11)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 11)", ""))
				}
				{
					p.SetState(71)

					var _lt = p.GetTokenStream().LT(1)

					localctx.(*InfixExprContext).op = _lt

					_la = p.GetTokenStream().LA(1)

					if !(_la == LangParserOP_EQ || _la == LangParserOP_NEQ) {
						var _ri = p.GetErrorHandler().RecoverInline(p)

						localctx.(*InfixExprContext).op = _ri
					} else {
						p.GetErrorHandler().ReportMatch(p)
						p.Consume()
					}
				}
				{
					p.SetState(72)

					var _x = p.expr(12)

					localctx.(*InfixExprContext).right = _x
				}

			case 7:
				localctx = NewInfixExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*InfixExprContext).left = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(73)

				if !(p.Precpred(p.GetParserRuleContext(), 10)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 10)", ""))
				}
				{
					p.SetState(74)

					var _m = p.Match(LangParserOP_BAND)

					localctx.(*InfixExprContext).op = _m
				}
				{
					p.SetState(75)

					var _x = p.expr(11)

					localctx.(*InfixExprContext).right = _x
				}

			case 8:
				localctx = NewInfixExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*InfixExprContext).left = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(76)

				if !(p.Precpred(p.GetParserRuleContext(), 9)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 9)", ""))
				}
				{
					p.SetState(77)

					var _m = p.Match(LangParserOP_BOR)

					localctx.(*InfixExprContext).op = _m
				}
				{
					p.SetState(78)

					var _x = p.expr(10)

					localctx.(*InfixExprContext).right = _x
				}

			case 9:
				localctx = NewInfixExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*InfixExprContext).left = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(79)

				if !(p.Precpred(p.GetParserRuleContext(), 8)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 8)", ""))
				}
				{
					p.SetState(80)

					var _m = p.Match(LangParserOP_BXOR)

					localctx.(*InfixExprContext).op = _m
				}
				{
					p.SetState(81)

					var _x = p.expr(9)

					localctx.(*InfixExprContext).right = _x
				}

			case 10:
				localctx = NewInfixExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*InfixExprContext).left = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(82)

				if !(p.Precpred(p.GetParserRuleContext(), 7)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 7)", ""))
				}
				{
					p.SetState(83)

					var _m = p.Match(LangParserOP_LAND)

					localctx.(*InfixExprContext).op = _m
				}
				{
					p.SetState(84)

					var _x = p.expr(8)

					localctx.(*InfixExprContext).right = _x
				}

			case 11:
				localctx = NewInfixExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*InfixExprContext).left = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(85)

				if !(p.Precpred(p.GetParserRuleContext(), 6)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 6)", ""))
				}
				{
					p.SetState(86)

					var _m = p.Match(LangParserOP_LOR)

					localctx.(*InfixExprContext).op = _m
				}
				{
					p.SetState(87)

					var _x = p.expr(7)

					localctx.(*InfixExprContext).right = _x
				}

			case 12:
				localctx = NewTernaryExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*TernaryExprContext).cond = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(88)

				if !(p.Precpred(p.GetParserRuleContext(), 5)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 5)", ""))
				}
				{
					p.SetState(89)
					p.Match(LangParserT__4)
				}
				{
					p.SetState(90)

					var _x = p.expr(0)

					localctx.(*TernaryExprContext).left = _x
				}
				{
					p.SetState(91)
					p.Match(LangParserT__5)
				}
				{
					p.SetState(92)

					var _x = p.expr(6)

					localctx.(*TernaryExprContext).right = _x
				}

			case 13:
				localctx = NewAssignmentExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*AssignmentExprContext).left = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(94)

				if !(p.Precpred(p.GetParserRuleContext(), 4)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 4)", ""))
				}
				{
					p.SetState(95)

					var _lt = p.GetTokenStream().LT(1)

					localctx.(*AssignmentExprContext).op = _lt

					_la = p.GetTokenStream().LA(1)

					if !(((_la-48)&-(0x1f+1)) == 0 && ((1<<uint((_la-48)))&((1<<(LangParserOP_ASG-48))|(1<<(LangParserOP_ADD_ASG-48))|(1<<(LangParserOP_SUB_ASG-48))|(1<<(LangParserOP_MUL_ASG-48))|(1<<(LangParserOP_DIV_ASG-48))|(1<<(LangParserOP_MOD_ASG-48))|(1<<(LangParserOP_LSH_ASG-48))|(1<<(LangParserOP_RSH_ASG-48))|(1<<(LangParserOP_BAND_ASG-48))|(1<<(LangParserOP_BXOR_ASG-48))|(1<<(LangParserOP_BOR_ASG-48)))) != 0) {
						var _ri = p.GetErrorHandler().RecoverInline(p)

						localctx.(*AssignmentExprContext).op = _ri
					} else {
						p.GetErrorHandler().ReportMatch(p)
						p.Consume()
					}
				}
				{
					p.SetState(96)

					var _x = p.expr(5)

					localctx.(*AssignmentExprContext).right = _x
				}

			case 14:
				localctx = NewFuncExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*FuncExprContext).name = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(97)

				if !(p.Precpred(p.GetParserRuleContext(), 23)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 23)", ""))
				}
				{
					p.SetState(98)
					p.Match(LangParserT__0)
				}
				{
					p.SetState(99)

					var _x = p.FuncArgsExpr()

					localctx.(*FuncExprContext).args = _x
				}
				{
					p.SetState(100)
					p.Match(LangParserT__1)
				}

			case 15:
				localctx = NewArrayExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*ArrayExprContext).varName = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(102)

				if !(p.Precpred(p.GetParserRuleContext(), 22)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 22)", ""))
				}
				{
					p.SetState(103)
					p.Match(LangParserT__2)
				}
				{
					p.SetState(104)

					var _x = p.expr(0)

					localctx.(*ArrayExprContext).sub = _x
				}
				{
					p.SetState(105)
					p.Match(LangParserT__3)
				}

			case 16:
				localctx = NewPostfixExprContext(p, NewExprContext(p, _parentctx, _parentState))
				localctx.(*PostfixExprContext).varName = _prevctx

				p.PushNewRecursionContext(localctx, _startState, LangParserRULE_expr)
				p.SetState(107)

				if !(p.Precpred(p.GetParserRuleContext(), 20)) {
					panic(antlr.NewFailedPredicateException(p, "p.Precpred(p.GetParserRuleContext(), 20)", ""))
				}
				{
					p.SetState(108)
					_la = p.GetTokenStream().LA(1)

					if !(_la == LangParserOP_INC || _la == LangParserOP_DEC) {
						p.GetErrorHandler().RecoverInline(p)
					} else {
						p.GetErrorHandler().ReportMatch(p)
						p.Consume()
					}
				}

			}

		}
		p.SetState(113)
		p.GetErrorHandler().Sync(p)
		_alt = p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 3, p.GetParserRuleContext())
	}

	return localctx
}

// IFuncArgsExprContext is an interface to support dynamic dispatch.
type IFuncArgsExprContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// IsFuncArgsExprContext differentiates from other interfaces.
	IsFuncArgsExprContext()
}

type FuncArgsExprContext struct {
	*antlr.BaseParserRuleContext
	parser antlr.Parser
}

func NewEmptyFuncArgsExprContext() *FuncArgsExprContext {
	var p = new(FuncArgsExprContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_funcArgsExpr
	return p
}

func (*FuncArgsExprContext) IsFuncArgsExprContext() {}

func NewFuncArgsExprContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *FuncArgsExprContext {
	var p = new(FuncArgsExprContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_funcArgsExpr

	return p
}

func (s *FuncArgsExprContext) GetParser() antlr.Parser { return s.parser }

func (s *FuncArgsExprContext) AllExpr() []IExprContext {
	var ts = s.GetTypedRuleContexts(reflect.TypeOf((*IExprContext)(nil)).Elem())
	var tst = make([]IExprContext, len(ts))

	for i, t := range ts {
		if t != nil {
			tst[i] = t.(IExprContext)
		}
	}

	return tst
}

func (s *FuncArgsExprContext) Expr(i int) IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), i)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *FuncArgsExprContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *FuncArgsExprContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *FuncArgsExprContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterFuncArgsExpr(s)
	}
}

func (s *FuncArgsExprContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitFuncArgsExpr(s)
	}
}

func (p *LangParser) FuncArgsExpr() (localctx IFuncArgsExprContext) {
	localctx = NewFuncArgsExprContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 4, LangParserRULE_funcArgsExpr)
	var _la int

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	var _alt int

	p.EnterOuterAlt(localctx, 1)
	p.SetState(119)
	p.GetErrorHandler().Sync(p)
	_alt = p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 4, p.GetParserRuleContext())

	for _alt != 2 && _alt != antlr.ATNInvalidAltNumber {
		if _alt == 1 {
			{
				p.SetState(114)
				p.expr(0)
			}
			{
				p.SetState(115)
				p.Match(LangParserT__6)
			}

		}
		p.SetState(121)
		p.GetErrorHandler().Sync(p)
		_alt = p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 4, p.GetParserRuleContext())
	}
	p.SetState(123)
	p.GetErrorHandler().Sync(p)
	_la = p.GetTokenStream().LA(1)

	if (((_la)&-(0x1f+1)) == 0 && ((1<<uint(_la))&((1<<LangParserT__0)|(1<<LangParserT__2)|(1<<LangParserT__5)|(1<<LangParserT__7)|(1<<LangParserT__9)|(1<<LangParserT__10)|(1<<LangParserOP_INC)|(1<<LangParserOP_DEC)|(1<<LangParserOP_LNOT)|(1<<LangParserOP_BNOT))) != 0) || (((_la-46)&-(0x1f+1)) == 0 && ((1<<uint((_la-46)))&((1<<(LangParserOP_ADD-46))|(1<<(LangParserOP_SUB-46))|(1<<(LangParserNUM-46))|(1<<(LangParserID-46))|(1<<(LangParserSTR-46))|(1<<(LangParserCHR-46)))) != 0) {
		{
			p.SetState(122)
			p.expr(0)
		}

	}

	return localctx
}

// IBlockContext is an interface to support dynamic dispatch.
type IBlockContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// IsBlockContext differentiates from other interfaces.
	IsBlockContext()
}

type BlockContext struct {
	*antlr.BaseParserRuleContext
	parser antlr.Parser
}

func NewEmptyBlockContext() *BlockContext {
	var p = new(BlockContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_block
	return p
}

func (*BlockContext) IsBlockContext() {}

func NewBlockContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *BlockContext {
	var p = new(BlockContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_block

	return p
}

func (s *BlockContext) GetParser() antlr.Parser { return s.parser }

func (s *BlockContext) AllStatment() []IStatmentContext {
	var ts = s.GetTypedRuleContexts(reflect.TypeOf((*IStatmentContext)(nil)).Elem())
	var tst = make([]IStatmentContext, len(ts))

	for i, t := range ts {
		if t != nil {
			tst[i] = t.(IStatmentContext)
		}
	}

	return tst
}

func (s *BlockContext) Statment(i int) IStatmentContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IStatmentContext)(nil)).Elem(), i)

	if t == nil {
		return nil
	}

	return t.(IStatmentContext)
}

func (s *BlockContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *BlockContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *BlockContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterBlock(s)
	}
}

func (s *BlockContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitBlock(s)
	}
}

func (p *LangParser) Block() (localctx IBlockContext) {
	localctx = NewBlockContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 6, LangParserRULE_block)
	var _la int

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	p.EnterOuterAlt(localctx, 1)
	{
		p.SetState(125)
		p.Match(LangParserT__7)
	}
	p.SetState(129)
	p.GetErrorHandler().Sync(p)
	_la = p.GetTokenStream().LA(1)

	for (((_la)&-(0x1f+1)) == 0 && ((1<<uint(_la))&((1<<LangParserT__0)|(1<<LangParserT__2)|(1<<LangParserT__5)|(1<<LangParserT__7)|(1<<LangParserT__9)|(1<<LangParserT__10)|(1<<LangParserT__11)|(1<<LangParserT__12)|(1<<LangParserT__13)|(1<<LangParserT__14)|(1<<LangParserT__15)|(1<<LangParserT__16)|(1<<LangParserT__17)|(1<<LangParserT__18)|(1<<LangParserT__20)|(1<<LangParserT__21)|(1<<LangParserT__22)|(1<<LangParserT__23)|(1<<LangParserOP_INC)|(1<<LangParserOP_DEC)|(1<<LangParserOP_LNOT)|(1<<LangParserOP_BNOT))) != 0) || (((_la-46)&-(0x1f+1)) == 0 && ((1<<uint((_la-46)))&((1<<(LangParserOP_ADD-46))|(1<<(LangParserOP_SUB-46))|(1<<(LangParserNUM-46))|(1<<(LangParserID-46))|(1<<(LangParserSTR-46))|(1<<(LangParserCHR-46)))) != 0) {
		{
			p.SetState(126)
			p.Statment()
		}

		p.SetState(131)
		p.GetErrorHandler().Sync(p)
		_la = p.GetTokenStream().LA(1)
	}
	{
		p.SetState(132)
		p.Match(LangParserT__8)
	}

	return localctx
}

// ITypeDeclContext is an interface to support dynamic dispatch.
type ITypeDeclContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// GetSize returns the size rule contexts.
	GetSize() ILiteralContext

	// SetSize sets the size rule contexts.
	SetSize(ILiteralContext)

	// IsTypeDeclContext differentiates from other interfaces.
	IsTypeDeclContext()
}

type TypeDeclContext struct {
	*antlr.BaseParserRuleContext
	parser antlr.Parser
	size   ILiteralContext
}

func NewEmptyTypeDeclContext() *TypeDeclContext {
	var p = new(TypeDeclContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_typeDecl
	return p
}

func (*TypeDeclContext) IsTypeDeclContext() {}

func NewTypeDeclContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *TypeDeclContext {
	var p = new(TypeDeclContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_typeDecl

	return p
}

func (s *TypeDeclContext) GetParser() antlr.Parser { return s.parser }

func (s *TypeDeclContext) GetSize() ILiteralContext { return s.size }

func (s *TypeDeclContext) SetSize(v ILiteralContext) { s.size = v }

func (s *TypeDeclContext) ID() antlr.TerminalNode {
	return s.GetToken(LangParserID, 0)
}

func (s *TypeDeclContext) FuncType() IFuncTypeContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IFuncTypeContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IFuncTypeContext)
}

func (s *TypeDeclContext) Literal() ILiteralContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*ILiteralContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(ILiteralContext)
}

func (s *TypeDeclContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *TypeDeclContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *TypeDeclContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterTypeDecl(s)
	}
}

func (s *TypeDeclContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitTypeDecl(s)
	}
}

func (p *LangParser) TypeDecl() (localctx ITypeDeclContext) {
	localctx = NewTypeDeclContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 8, LangParserRULE_typeDecl)
	var _la int

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	p.EnterOuterAlt(localctx, 1)
	p.SetState(136)
	p.GetErrorHandler().Sync(p)
	switch p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 7, p.GetParserRuleContext()) {
	case 1:
		{
			p.SetState(134)
			p.Match(LangParserID)
		}

	case 2:
		{
			p.SetState(135)
			p.FuncType()
		}

	}
	p.SetState(143)
	p.GetErrorHandler().Sync(p)

	if p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 9, p.GetParserRuleContext()) == 1 {
		{
			p.SetState(138)
			p.Match(LangParserT__2)
		}
		p.SetState(140)
		p.GetErrorHandler().Sync(p)
		_la = p.GetTokenStream().LA(1)

		if _la == LangParserT__2 || (((_la-59)&-(0x1f+1)) == 0 && ((1<<uint((_la-59)))&((1<<(LangParserNUM-59))|(1<<(LangParserSTR-59))|(1<<(LangParserCHR-59)))) != 0) {
			{
				p.SetState(139)

				var _x = p.Literal()

				localctx.(*TypeDeclContext).size = _x
			}

		}
		{
			p.SetState(142)
			p.Match(LangParserT__3)
		}

	}

	return localctx
}

// IVarTypeContext is an interface to support dynamic dispatch.
type IVarTypeContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// GetName returns the name token.
	GetName() antlr.Token

	// SetName sets the name token.
	SetName(antlr.Token)

	// GetTypeName returns the typeName rule contexts.
	GetTypeName() ITypeDeclContext

	// SetTypeName sets the typeName rule contexts.
	SetTypeName(ITypeDeclContext)

	// IsVarTypeContext differentiates from other interfaces.
	IsVarTypeContext()
}

type VarTypeContext struct {
	*antlr.BaseParserRuleContext
	parser   antlr.Parser
	name     antlr.Token
	typeName ITypeDeclContext
}

func NewEmptyVarTypeContext() *VarTypeContext {
	var p = new(VarTypeContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_varType
	return p
}

func (*VarTypeContext) IsVarTypeContext() {}

func NewVarTypeContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *VarTypeContext {
	var p = new(VarTypeContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_varType

	return p
}

func (s *VarTypeContext) GetParser() antlr.Parser { return s.parser }

func (s *VarTypeContext) GetName() antlr.Token { return s.name }

func (s *VarTypeContext) SetName(v antlr.Token) { s.name = v }

func (s *VarTypeContext) GetTypeName() ITypeDeclContext { return s.typeName }

func (s *VarTypeContext) SetTypeName(v ITypeDeclContext) { s.typeName = v }

func (s *VarTypeContext) ID() antlr.TerminalNode {
	return s.GetToken(LangParserID, 0)
}

func (s *VarTypeContext) TypeDecl() ITypeDeclContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*ITypeDeclContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(ITypeDeclContext)
}

func (s *VarTypeContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *VarTypeContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *VarTypeContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterVarType(s)
	}
}

func (s *VarTypeContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitVarType(s)
	}
}

func (p *LangParser) VarType() (localctx IVarTypeContext) {
	localctx = NewVarTypeContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 10, LangParserRULE_varType)

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	p.EnterOuterAlt(localctx, 1)
	{
		p.SetState(145)

		var _m = p.Match(LangParserID)

		localctx.(*VarTypeContext).name = _m
	}
	{
		p.SetState(146)
		p.Match(LangParserT__5)
	}
	{
		p.SetState(147)

		var _x = p.TypeDecl()

		localctx.(*VarTypeContext).typeName = _x
	}

	return localctx
}

// IVarDeclContext is an interface to support dynamic dispatch.
type IVarDeclContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// GetMut returns the mut token.
	GetMut() antlr.Token

	// SetMut sets the mut token.
	SetMut(antlr.Token)

	// GetTypeName returns the typeName rule contexts.
	GetTypeName() IVarTypeContext

	// GetInit returns the init rule contexts.
	GetInit() IExprContext

	// SetTypeName sets the typeName rule contexts.
	SetTypeName(IVarTypeContext)

	// SetInit sets the init rule contexts.
	SetInit(IExprContext)

	// IsVarDeclContext differentiates from other interfaces.
	IsVarDeclContext()
}

type VarDeclContext struct {
	*antlr.BaseParserRuleContext
	parser   antlr.Parser
	mut      antlr.Token
	typeName IVarTypeContext
	init     IExprContext
}

func NewEmptyVarDeclContext() *VarDeclContext {
	var p = new(VarDeclContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_varDecl
	return p
}

func (*VarDeclContext) IsVarDeclContext() {}

func NewVarDeclContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *VarDeclContext {
	var p = new(VarDeclContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_varDecl

	return p
}

func (s *VarDeclContext) GetParser() antlr.Parser { return s.parser }

func (s *VarDeclContext) GetMut() antlr.Token { return s.mut }

func (s *VarDeclContext) SetMut(v antlr.Token) { s.mut = v }

func (s *VarDeclContext) GetTypeName() IVarTypeContext { return s.typeName }

func (s *VarDeclContext) GetInit() IExprContext { return s.init }

func (s *VarDeclContext) SetTypeName(v IVarTypeContext) { s.typeName = v }

func (s *VarDeclContext) SetInit(v IExprContext) { s.init = v }

func (s *VarDeclContext) VarType() IVarTypeContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IVarTypeContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IVarTypeContext)
}

func (s *VarDeclContext) Expr() IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *VarDeclContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *VarDeclContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *VarDeclContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterVarDecl(s)
	}
}

func (s *VarDeclContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitVarDecl(s)
	}
}

func (p *LangParser) VarDecl() (localctx IVarDeclContext) {
	localctx = NewVarDeclContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 12, LangParserRULE_varDecl)
	var _la int

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	p.EnterOuterAlt(localctx, 1)
	{
		p.SetState(149)

		var _lt = p.GetTokenStream().LT(1)

		localctx.(*VarDeclContext).mut = _lt

		_la = p.GetTokenStream().LA(1)

		if !(_la == LangParserT__9 || _la == LangParserT__10) {
			var _ri = p.GetErrorHandler().RecoverInline(p)

			localctx.(*VarDeclContext).mut = _ri
		} else {
			p.GetErrorHandler().ReportMatch(p)
			p.Consume()
		}
	}
	{
		p.SetState(150)

		var _x = p.VarType()

		localctx.(*VarDeclContext).typeName = _x
	}
	p.SetState(153)
	p.GetErrorHandler().Sync(p)

	if p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 10, p.GetParserRuleContext()) == 1 {
		{
			p.SetState(151)
			p.Match(LangParserOP_ASG)
		}
		{
			p.SetState(152)

			var _x = p.expr(0)

			localctx.(*VarDeclContext).init = _x
		}

	}

	return localctx
}

// IFuncArgDeclContext is an interface to support dynamic dispatch.
type IFuncArgDeclContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// IsFuncArgDeclContext differentiates from other interfaces.
	IsFuncArgDeclContext()
}

type FuncArgDeclContext struct {
	*antlr.BaseParserRuleContext
	parser antlr.Parser
}

func NewEmptyFuncArgDeclContext() *FuncArgDeclContext {
	var p = new(FuncArgDeclContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_funcArgDecl
	return p
}

func (*FuncArgDeclContext) IsFuncArgDeclContext() {}

func NewFuncArgDeclContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *FuncArgDeclContext {
	var p = new(FuncArgDeclContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_funcArgDecl

	return p
}

func (s *FuncArgDeclContext) GetParser() antlr.Parser { return s.parser }

func (s *FuncArgDeclContext) AllVarType() []IVarTypeContext {
	var ts = s.GetTypedRuleContexts(reflect.TypeOf((*IVarTypeContext)(nil)).Elem())
	var tst = make([]IVarTypeContext, len(ts))

	for i, t := range ts {
		if t != nil {
			tst[i] = t.(IVarTypeContext)
		}
	}

	return tst
}

func (s *FuncArgDeclContext) VarType(i int) IVarTypeContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IVarTypeContext)(nil)).Elem(), i)

	if t == nil {
		return nil
	}

	return t.(IVarTypeContext)
}

func (s *FuncArgDeclContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *FuncArgDeclContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *FuncArgDeclContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterFuncArgDecl(s)
	}
}

func (s *FuncArgDeclContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitFuncArgDecl(s)
	}
}

func (p *LangParser) FuncArgDecl() (localctx IFuncArgDeclContext) {
	localctx = NewFuncArgDeclContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 14, LangParserRULE_funcArgDecl)
	var _la int

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	var _alt int

	p.EnterOuterAlt(localctx, 1)
	p.SetState(160)
	p.GetErrorHandler().Sync(p)
	_alt = p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 11, p.GetParserRuleContext())

	for _alt != 2 && _alt != antlr.ATNInvalidAltNumber {
		if _alt == 1 {
			{
				p.SetState(155)
				p.VarType()
			}
			{
				p.SetState(156)
				p.Match(LangParserT__6)
			}

		}
		p.SetState(162)
		p.GetErrorHandler().Sync(p)
		_alt = p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 11, p.GetParserRuleContext())
	}
	p.SetState(164)
	p.GetErrorHandler().Sync(p)
	_la = p.GetTokenStream().LA(1)

	if _la == LangParserID {
		{
			p.SetState(163)
			p.VarType()
		}

	}

	return localctx
}

// IFuncTypeContext is an interface to support dynamic dispatch.
type IFuncTypeContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// GetArgs returns the args rule contexts.
	GetArgs() IFuncArgDeclContext

	// GetRetType returns the retType rule contexts.
	GetRetType() ITypeDeclContext

	// SetArgs sets the args rule contexts.
	SetArgs(IFuncArgDeclContext)

	// SetRetType sets the retType rule contexts.
	SetRetType(ITypeDeclContext)

	// IsFuncTypeContext differentiates from other interfaces.
	IsFuncTypeContext()
}

type FuncTypeContext struct {
	*antlr.BaseParserRuleContext
	parser  antlr.Parser
	args    IFuncArgDeclContext
	retType ITypeDeclContext
}

func NewEmptyFuncTypeContext() *FuncTypeContext {
	var p = new(FuncTypeContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_funcType
	return p
}

func (*FuncTypeContext) IsFuncTypeContext() {}

func NewFuncTypeContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *FuncTypeContext {
	var p = new(FuncTypeContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_funcType

	return p
}

func (s *FuncTypeContext) GetParser() antlr.Parser { return s.parser }

func (s *FuncTypeContext) GetArgs() IFuncArgDeclContext { return s.args }

func (s *FuncTypeContext) GetRetType() ITypeDeclContext { return s.retType }

func (s *FuncTypeContext) SetArgs(v IFuncArgDeclContext) { s.args = v }

func (s *FuncTypeContext) SetRetType(v ITypeDeclContext) { s.retType = v }

func (s *FuncTypeContext) FuncArgDecl() IFuncArgDeclContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IFuncArgDeclContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IFuncArgDeclContext)
}

func (s *FuncTypeContext) TypeDecl() ITypeDeclContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*ITypeDeclContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(ITypeDeclContext)
}

func (s *FuncTypeContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *FuncTypeContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *FuncTypeContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterFuncType(s)
	}
}

func (s *FuncTypeContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitFuncType(s)
	}
}

func (p *LangParser) FuncType() (localctx IFuncTypeContext) {
	localctx = NewFuncTypeContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 16, LangParserRULE_funcType)

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	p.EnterOuterAlt(localctx, 1)
	p.SetState(170)
	p.GetErrorHandler().Sync(p)

	if p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 13, p.GetParserRuleContext()) == 1 {
		{
			p.SetState(166)
			p.Match(LangParserT__0)
		}
		{
			p.SetState(167)

			var _x = p.FuncArgDecl()

			localctx.(*FuncTypeContext).args = _x
		}
		{
			p.SetState(168)
			p.Match(LangParserT__1)
		}

	}
	p.SetState(174)
	p.GetErrorHandler().Sync(p)

	if p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 14, p.GetParserRuleContext()) == 1 {
		{
			p.SetState(172)
			p.Match(LangParserT__5)
		}
		{
			p.SetState(173)

			var _x = p.TypeDecl()

			localctx.(*FuncTypeContext).retType = _x
		}

	}

	return localctx
}

// IFuncBodyContext is an interface to support dynamic dispatch.
type IFuncBodyContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// GetTypeName returns the typeName rule contexts.
	GetTypeName() IFuncTypeContext

	// GetCode returns the code rule contexts.
	GetCode() IBlockContext

	// SetTypeName sets the typeName rule contexts.
	SetTypeName(IFuncTypeContext)

	// SetCode sets the code rule contexts.
	SetCode(IBlockContext)

	// IsFuncBodyContext differentiates from other interfaces.
	IsFuncBodyContext()
}

type FuncBodyContext struct {
	*antlr.BaseParserRuleContext
	parser   antlr.Parser
	typeName IFuncTypeContext
	code     IBlockContext
}

func NewEmptyFuncBodyContext() *FuncBodyContext {
	var p = new(FuncBodyContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_funcBody
	return p
}

func (*FuncBodyContext) IsFuncBodyContext() {}

func NewFuncBodyContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *FuncBodyContext {
	var p = new(FuncBodyContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_funcBody

	return p
}

func (s *FuncBodyContext) GetParser() antlr.Parser { return s.parser }

func (s *FuncBodyContext) GetTypeName() IFuncTypeContext { return s.typeName }

func (s *FuncBodyContext) GetCode() IBlockContext { return s.code }

func (s *FuncBodyContext) SetTypeName(v IFuncTypeContext) { s.typeName = v }

func (s *FuncBodyContext) SetCode(v IBlockContext) { s.code = v }

func (s *FuncBodyContext) FuncType() IFuncTypeContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IFuncTypeContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IFuncTypeContext)
}

func (s *FuncBodyContext) Block() IBlockContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IBlockContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IBlockContext)
}

func (s *FuncBodyContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *FuncBodyContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *FuncBodyContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterFuncBody(s)
	}
}

func (s *FuncBodyContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitFuncBody(s)
	}
}

func (p *LangParser) FuncBody() (localctx IFuncBodyContext) {
	localctx = NewFuncBodyContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 18, LangParserRULE_funcBody)

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	p.EnterOuterAlt(localctx, 1)
	{
		p.SetState(176)

		var _x = p.FuncType()

		localctx.(*FuncBodyContext).typeName = _x
	}
	{
		p.SetState(177)

		var _x = p.Block()

		localctx.(*FuncBodyContext).code = _x
	}

	return localctx
}

// IFuncDeclContext is an interface to support dynamic dispatch.
type IFuncDeclContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// GetName returns the name token.
	GetName() antlr.Token

	// SetName sets the name token.
	SetName(antlr.Token)

	// GetFunction returns the function rule contexts.
	GetFunction() IFuncBodyContext

	// SetFunction sets the function rule contexts.
	SetFunction(IFuncBodyContext)

	// IsFuncDeclContext differentiates from other interfaces.
	IsFuncDeclContext()
}

type FuncDeclContext struct {
	*antlr.BaseParserRuleContext
	parser   antlr.Parser
	name     antlr.Token
	function IFuncBodyContext
}

func NewEmptyFuncDeclContext() *FuncDeclContext {
	var p = new(FuncDeclContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_funcDecl
	return p
}

func (*FuncDeclContext) IsFuncDeclContext() {}

func NewFuncDeclContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *FuncDeclContext {
	var p = new(FuncDeclContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_funcDecl

	return p
}

func (s *FuncDeclContext) GetParser() antlr.Parser { return s.parser }

func (s *FuncDeclContext) GetName() antlr.Token { return s.name }

func (s *FuncDeclContext) SetName(v antlr.Token) { s.name = v }

func (s *FuncDeclContext) GetFunction() IFuncBodyContext { return s.function }

func (s *FuncDeclContext) SetFunction(v IFuncBodyContext) { s.function = v }

func (s *FuncDeclContext) ID() antlr.TerminalNode {
	return s.GetToken(LangParserID, 0)
}

func (s *FuncDeclContext) FuncBody() IFuncBodyContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IFuncBodyContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IFuncBodyContext)
}

func (s *FuncDeclContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *FuncDeclContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *FuncDeclContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterFuncDecl(s)
	}
}

func (s *FuncDeclContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitFuncDecl(s)
	}
}

func (p *LangParser) FuncDecl() (localctx IFuncDeclContext) {
	localctx = NewFuncDeclContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 20, LangParserRULE_funcDecl)

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	p.EnterOuterAlt(localctx, 1)
	{
		p.SetState(179)
		p.Match(LangParserT__11)
	}
	{
		p.SetState(180)

		var _m = p.Match(LangParserID)

		localctx.(*FuncDeclContext).name = _m
	}
	{
		p.SetState(181)

		var _x = p.FuncBody()

		localctx.(*FuncDeclContext).function = _x
	}

	return localctx
}

// IClassDeclContext is an interface to support dynamic dispatch.
type IClassDeclContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// GetClassType returns the classType token.
	GetClassType() antlr.Token

	// GetName returns the name token.
	GetName() antlr.Token

	// GetParentClass returns the parentClass token.
	GetParentClass() antlr.Token

	// SetClassType sets the classType token.
	SetClassType(antlr.Token)

	// SetName sets the name token.
	SetName(antlr.Token)

	// SetParentClass sets the parentClass token.
	SetParentClass(antlr.Token)

	// GetBody returns the body rule contexts.
	GetBody() IBlockContext

	// SetBody sets the body rule contexts.
	SetBody(IBlockContext)

	// IsClassDeclContext differentiates from other interfaces.
	IsClassDeclContext()
}

type ClassDeclContext struct {
	*antlr.BaseParserRuleContext
	parser      antlr.Parser
	classType   antlr.Token
	name        antlr.Token
	parentClass antlr.Token
	body        IBlockContext
}

func NewEmptyClassDeclContext() *ClassDeclContext {
	var p = new(ClassDeclContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_classDecl
	return p
}

func (*ClassDeclContext) IsClassDeclContext() {}

func NewClassDeclContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *ClassDeclContext {
	var p = new(ClassDeclContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_classDecl

	return p
}

func (s *ClassDeclContext) GetParser() antlr.Parser { return s.parser }

func (s *ClassDeclContext) GetClassType() antlr.Token { return s.classType }

func (s *ClassDeclContext) GetName() antlr.Token { return s.name }

func (s *ClassDeclContext) GetParentClass() antlr.Token { return s.parentClass }

func (s *ClassDeclContext) SetClassType(v antlr.Token) { s.classType = v }

func (s *ClassDeclContext) SetName(v antlr.Token) { s.name = v }

func (s *ClassDeclContext) SetParentClass(v antlr.Token) { s.parentClass = v }

func (s *ClassDeclContext) GetBody() IBlockContext { return s.body }

func (s *ClassDeclContext) SetBody(v IBlockContext) { s.body = v }

func (s *ClassDeclContext) AllID() []antlr.TerminalNode {
	return s.GetTokens(LangParserID)
}

func (s *ClassDeclContext) ID(i int) antlr.TerminalNode {
	return s.GetToken(LangParserID, i)
}

func (s *ClassDeclContext) Block() IBlockContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IBlockContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IBlockContext)
}

func (s *ClassDeclContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ClassDeclContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *ClassDeclContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterClassDecl(s)
	}
}

func (s *ClassDeclContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitClassDecl(s)
	}
}

func (p *LangParser) ClassDecl() (localctx IClassDeclContext) {
	localctx = NewClassDeclContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 22, LangParserRULE_classDecl)
	var _la int

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	p.EnterOuterAlt(localctx, 1)
	{
		p.SetState(183)

		var _lt = p.GetTokenStream().LT(1)

		localctx.(*ClassDeclContext).classType = _lt

		_la = p.GetTokenStream().LA(1)

		if !(((_la)&-(0x1f+1)) == 0 && ((1<<uint(_la))&((1<<LangParserT__12)|(1<<LangParserT__13)|(1<<LangParserT__14))) != 0) {
			var _ri = p.GetErrorHandler().RecoverInline(p)

			localctx.(*ClassDeclContext).classType = _ri
		} else {
			p.GetErrorHandler().ReportMatch(p)
			p.Consume()
		}
	}
	{
		p.SetState(184)

		var _m = p.Match(LangParserID)

		localctx.(*ClassDeclContext).name = _m
	}
	p.SetState(187)
	p.GetErrorHandler().Sync(p)
	_la = p.GetTokenStream().LA(1)

	if _la == LangParserT__5 {
		{
			p.SetState(185)
			p.Match(LangParserT__5)
		}
		{
			p.SetState(186)

			var _m = p.Match(LangParserID)

			localctx.(*ClassDeclContext).parentClass = _m
		}

	}
	{
		p.SetState(189)

		var _x = p.Block()

		localctx.(*ClassDeclContext).body = _x
	}

	return localctx
}

// IStatmentContext is an interface to support dynamic dispatch.
type IStatmentContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// IsStatmentContext differentiates from other interfaces.
	IsStatmentContext()
}

type StatmentContext struct {
	*antlr.BaseParserRuleContext
	parser antlr.Parser
}

func NewEmptyStatmentContext() *StatmentContext {
	var p = new(StatmentContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_statment
	return p
}

func (*StatmentContext) IsStatmentContext() {}

func NewStatmentContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *StatmentContext {
	var p = new(StatmentContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_statment

	return p
}

func (s *StatmentContext) GetParser() antlr.Parser { return s.parser }

func (s *StatmentContext) CopyFrom(ctx *StatmentContext) {
	s.BaseParserRuleContext.CopyFrom(ctx.BaseParserRuleContext)
}

func (s *StatmentContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *StatmentContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

type ContinueStmntContext struct {
	*StatmentContext
}

func NewContinueStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *ContinueStmntContext {
	var p = new(ContinueStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *ContinueStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ContinueStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterContinueStmnt(s)
	}
}

func (s *ContinueStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitContinueStmnt(s)
	}
}

type DoWhileStmntContext struct {
	*StatmentContext
	code IBlockContext
	cond IExprContext
}

func NewDoWhileStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *DoWhileStmntContext {
	var p = new(DoWhileStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *DoWhileStmntContext) GetCode() IBlockContext { return s.code }

func (s *DoWhileStmntContext) GetCond() IExprContext { return s.cond }

func (s *DoWhileStmntContext) SetCode(v IBlockContext) { s.code = v }

func (s *DoWhileStmntContext) SetCond(v IExprContext) { s.cond = v }

func (s *DoWhileStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *DoWhileStmntContext) Block() IBlockContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IBlockContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IBlockContext)
}

func (s *DoWhileStmntContext) Expr() IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *DoWhileStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterDoWhileStmnt(s)
	}
}

func (s *DoWhileStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitDoWhileStmnt(s)
	}
}

type ReturnStmntContext struct {
	*StatmentContext
	val IExprContext
}

func NewReturnStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *ReturnStmntContext {
	var p = new(ReturnStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *ReturnStmntContext) GetVal() IExprContext { return s.val }

func (s *ReturnStmntContext) SetVal(v IExprContext) { s.val = v }

func (s *ReturnStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ReturnStmntContext) Expr() IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *ReturnStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterReturnStmnt(s)
	}
}

func (s *ReturnStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitReturnStmnt(s)
	}
}

type BlockStmntContext struct {
	*StatmentContext
	code IBlockContext
}

func NewBlockStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *BlockStmntContext {
	var p = new(BlockStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *BlockStmntContext) GetCode() IBlockContext { return s.code }

func (s *BlockStmntContext) SetCode(v IBlockContext) { s.code = v }

func (s *BlockStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *BlockStmntContext) Block() IBlockContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IBlockContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IBlockContext)
}

func (s *BlockStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterBlockStmnt(s)
	}
}

func (s *BlockStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitBlockStmnt(s)
	}
}

type ClassDeclStmntContext struct {
	*StatmentContext
	classType IClassDeclContext
}

func NewClassDeclStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *ClassDeclStmntContext {
	var p = new(ClassDeclStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *ClassDeclStmntContext) GetClassType() IClassDeclContext { return s.classType }

func (s *ClassDeclStmntContext) SetClassType(v IClassDeclContext) { s.classType = v }

func (s *ClassDeclStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ClassDeclStmntContext) ClassDecl() IClassDeclContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IClassDeclContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IClassDeclContext)
}

func (s *ClassDeclStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterClassDeclStmnt(s)
	}
}

func (s *ClassDeclStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitClassDeclStmnt(s)
	}
}

type ExprStmntContext struct {
	*StatmentContext
}

func NewExprStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *ExprStmntContext {
	var p = new(ExprStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *ExprStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ExprStmntContext) Expr() IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *ExprStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterExprStmnt(s)
	}
}

func (s *ExprStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitExprStmnt(s)
	}
}

type WhileStmntContext struct {
	*StatmentContext
	cond IExprContext
	code IBlockContext
}

func NewWhileStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *WhileStmntContext {
	var p = new(WhileStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *WhileStmntContext) GetCond() IExprContext { return s.cond }

func (s *WhileStmntContext) GetCode() IBlockContext { return s.code }

func (s *WhileStmntContext) SetCond(v IExprContext) { s.cond = v }

func (s *WhileStmntContext) SetCode(v IBlockContext) { s.code = v }

func (s *WhileStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *WhileStmntContext) Expr() IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *WhileStmntContext) Block() IBlockContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IBlockContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IBlockContext)
}

func (s *WhileStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterWhileStmnt(s)
	}
}

func (s *WhileStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitWhileStmnt(s)
	}
}

type IfStmntContext struct {
	*StatmentContext
	cond IExprContext
	code IBlockContext
}

func NewIfStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *IfStmntContext {
	var p = new(IfStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *IfStmntContext) GetCond() IExprContext { return s.cond }

func (s *IfStmntContext) GetCode() IBlockContext { return s.code }

func (s *IfStmntContext) SetCond(v IExprContext) { s.cond = v }

func (s *IfStmntContext) SetCode(v IBlockContext) { s.code = v }

func (s *IfStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *IfStmntContext) Expr() IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *IfStmntContext) Block() IBlockContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IBlockContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IBlockContext)
}

func (s *IfStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterIfStmnt(s)
	}
}

func (s *IfStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitIfStmnt(s)
	}
}

type ElseIfStmntContext struct {
	*StatmentContext
	cond IExprContext
	code IBlockContext
}

func NewElseIfStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *ElseIfStmntContext {
	var p = new(ElseIfStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *ElseIfStmntContext) GetCond() IExprContext { return s.cond }

func (s *ElseIfStmntContext) GetCode() IBlockContext { return s.code }

func (s *ElseIfStmntContext) SetCond(v IExprContext) { s.cond = v }

func (s *ElseIfStmntContext) SetCode(v IBlockContext) { s.code = v }

func (s *ElseIfStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ElseIfStmntContext) Expr() IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *ElseIfStmntContext) Block() IBlockContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IBlockContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IBlockContext)
}

func (s *ElseIfStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterElseIfStmnt(s)
	}
}

func (s *ElseIfStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitElseIfStmnt(s)
	}
}

type ElseStmntContext struct {
	*StatmentContext
	code IBlockContext
}

func NewElseStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *ElseStmntContext {
	var p = new(ElseStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *ElseStmntContext) GetCode() IBlockContext { return s.code }

func (s *ElseStmntContext) SetCode(v IBlockContext) { s.code = v }

func (s *ElseStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ElseStmntContext) Block() IBlockContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IBlockContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IBlockContext)
}

func (s *ElseStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterElseStmnt(s)
	}
}

func (s *ElseStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitElseStmnt(s)
	}
}

type ForStmntContext struct {
	*StatmentContext
	init IExprContext
	rep  IExprContext
	end  IExprContext
	code IBlockContext
}

func NewForStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *ForStmntContext {
	var p = new(ForStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *ForStmntContext) GetInit() IExprContext { return s.init }

func (s *ForStmntContext) GetRep() IExprContext { return s.rep }

func (s *ForStmntContext) GetEnd() IExprContext { return s.end }

func (s *ForStmntContext) GetCode() IBlockContext { return s.code }

func (s *ForStmntContext) SetInit(v IExprContext) { s.init = v }

func (s *ForStmntContext) SetRep(v IExprContext) { s.rep = v }

func (s *ForStmntContext) SetEnd(v IExprContext) { s.end = v }

func (s *ForStmntContext) SetCode(v IBlockContext) { s.code = v }

func (s *ForStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ForStmntContext) AllExpr() []IExprContext {
	var ts = s.GetTypedRuleContexts(reflect.TypeOf((*IExprContext)(nil)).Elem())
	var tst = make([]IExprContext, len(ts))

	for i, t := range ts {
		if t != nil {
			tst[i] = t.(IExprContext)
		}
	}

	return tst
}

func (s *ForStmntContext) Expr(i int) IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), i)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *ForStmntContext) Block() IBlockContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IBlockContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IBlockContext)
}

func (s *ForStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterForStmnt(s)
	}
}

func (s *ForStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitForStmnt(s)
	}
}

type FuncDeclStmntContext struct {
	*StatmentContext
	function IFuncDeclContext
}

func NewFuncDeclStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *FuncDeclStmntContext {
	var p = new(FuncDeclStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *FuncDeclStmntContext) GetFunction() IFuncDeclContext { return s.function }

func (s *FuncDeclStmntContext) SetFunction(v IFuncDeclContext) { s.function = v }

func (s *FuncDeclStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *FuncDeclStmntContext) FuncDecl() IFuncDeclContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IFuncDeclContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IFuncDeclContext)
}

func (s *FuncDeclStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterFuncDeclStmnt(s)
	}
}

func (s *FuncDeclStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitFuncDeclStmnt(s)
	}
}

type BreakStmntContext struct {
	*StatmentContext
}

func NewBreakStmntContext(parser antlr.Parser, ctx antlr.ParserRuleContext) *BreakStmntContext {
	var p = new(BreakStmntContext)

	p.StatmentContext = NewEmptyStatmentContext()
	p.parser = parser
	p.CopyFrom(ctx.(*StatmentContext))

	return p
}

func (s *BreakStmntContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *BreakStmntContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterBreakStmnt(s)
	}
}

func (s *BreakStmntContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitBreakStmnt(s)
	}
}

func (p *LangParser) Statment() (localctx IStatmentContext) {
	localctx = NewStatmentContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 24, LangParserRULE_statment)

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	p.SetState(244)
	p.GetErrorHandler().Sync(p)
	switch p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 16, p.GetParserRuleContext()) {
	case 1:
		localctx = NewIfStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 1)
		{
			p.SetState(191)
			p.Match(LangParserT__15)
		}
		{
			p.SetState(192)
			p.Match(LangParserT__0)
		}
		{
			p.SetState(193)

			var _x = p.expr(0)

			localctx.(*IfStmntContext).cond = _x
		}
		{
			p.SetState(194)
			p.Match(LangParserT__1)
		}
		{
			p.SetState(195)

			var _x = p.Block()

			localctx.(*IfStmntContext).code = _x
		}

	case 2:
		localctx = NewElseIfStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 2)
		{
			p.SetState(197)
			p.Match(LangParserT__16)
		}
		{
			p.SetState(198)
			p.Match(LangParserT__15)
		}
		{
			p.SetState(199)
			p.Match(LangParserT__0)
		}
		{
			p.SetState(200)

			var _x = p.expr(0)

			localctx.(*ElseIfStmntContext).cond = _x
		}
		{
			p.SetState(201)
			p.Match(LangParserT__1)
		}
		{
			p.SetState(202)

			var _x = p.Block()

			localctx.(*ElseIfStmntContext).code = _x
		}

	case 3:
		localctx = NewElseStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 3)
		{
			p.SetState(204)
			p.Match(LangParserT__16)
		}
		{
			p.SetState(205)

			var _x = p.Block()

			localctx.(*ElseStmntContext).code = _x
		}

	case 4:
		localctx = NewWhileStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 4)
		{
			p.SetState(206)
			p.Match(LangParserT__17)
		}
		{
			p.SetState(207)
			p.Match(LangParserT__0)
		}
		{
			p.SetState(208)

			var _x = p.expr(0)

			localctx.(*WhileStmntContext).cond = _x
		}
		{
			p.SetState(209)
			p.Match(LangParserT__1)
		}
		{
			p.SetState(210)

			var _x = p.Block()

			localctx.(*WhileStmntContext).code = _x
		}

	case 5:
		localctx = NewDoWhileStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 5)
		{
			p.SetState(212)
			p.Match(LangParserT__18)
		}
		{
			p.SetState(213)

			var _x = p.Block()

			localctx.(*DoWhileStmntContext).code = _x
		}
		{
			p.SetState(214)
			p.Match(LangParserT__17)
		}
		{
			p.SetState(215)
			p.Match(LangParserT__0)
		}
		{
			p.SetState(216)

			var _x = p.expr(0)

			localctx.(*DoWhileStmntContext).cond = _x
		}
		{
			p.SetState(217)
			p.Match(LangParserT__1)
		}
		{
			p.SetState(218)
			p.Match(LangParserT__19)
		}

	case 6:
		localctx = NewForStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 6)
		{
			p.SetState(220)
			p.Match(LangParserT__20)
		}
		{
			p.SetState(221)
			p.Match(LangParserT__0)
		}
		{
			p.SetState(222)

			var _x = p.expr(0)

			localctx.(*ForStmntContext).init = _x
		}
		{
			p.SetState(223)
			p.Match(LangParserT__19)
		}
		{
			p.SetState(224)

			var _x = p.expr(0)

			localctx.(*ForStmntContext).rep = _x
		}
		{
			p.SetState(225)
			p.Match(LangParserT__19)
		}
		{
			p.SetState(226)

			var _x = p.expr(0)

			localctx.(*ForStmntContext).end = _x
		}
		{
			p.SetState(227)
			p.Match(LangParserT__1)
		}
		{
			p.SetState(228)

			var _x = p.Block()

			localctx.(*ForStmntContext).code = _x
		}

	case 7:
		localctx = NewReturnStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 7)
		{
			p.SetState(230)
			p.Match(LangParserT__21)
		}
		{
			p.SetState(231)

			var _x = p.expr(0)

			localctx.(*ReturnStmntContext).val = _x
		}
		{
			p.SetState(232)
			p.Match(LangParserT__19)
		}

	case 8:
		localctx = NewContinueStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 8)
		{
			p.SetState(234)
			p.Match(LangParserT__22)
		}
		{
			p.SetState(235)
			p.Match(LangParserT__19)
		}

	case 9:
		localctx = NewBreakStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 9)
		{
			p.SetState(236)
			p.Match(LangParserT__23)
		}
		{
			p.SetState(237)
			p.Match(LangParserT__19)
		}

	case 10:
		localctx = NewFuncDeclStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 10)
		{
			p.SetState(238)

			var _x = p.FuncDecl()

			localctx.(*FuncDeclStmntContext).function = _x
		}

	case 11:
		localctx = NewClassDeclStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 11)
		{
			p.SetState(239)

			var _x = p.ClassDecl()

			localctx.(*ClassDeclStmntContext).classType = _x
		}

	case 12:
		localctx = NewExprStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 12)
		{
			p.SetState(240)
			p.expr(0)
		}
		{
			p.SetState(241)
			p.Match(LangParserT__19)
		}

	case 13:
		localctx = NewBlockStmntContext(p, localctx)
		p.EnterOuterAlt(localctx, 13)
		{
			p.SetState(243)

			var _x = p.Block()

			localctx.(*BlockStmntContext).code = _x
		}

	}

	return localctx
}

// ILiteralContext is an interface to support dynamic dispatch.
type ILiteralContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// IsLiteralContext differentiates from other interfaces.
	IsLiteralContext()
}

type LiteralContext struct {
	*antlr.BaseParserRuleContext
	parser antlr.Parser
}

func NewEmptyLiteralContext() *LiteralContext {
	var p = new(LiteralContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_literal
	return p
}

func (*LiteralContext) IsLiteralContext() {}

func NewLiteralContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *LiteralContext {
	var p = new(LiteralContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_literal

	return p
}

func (s *LiteralContext) GetParser() antlr.Parser { return s.parser }

func (s *LiteralContext) NUM() antlr.TerminalNode {
	return s.GetToken(LangParserNUM, 0)
}

func (s *LiteralContext) STR() antlr.TerminalNode {
	return s.GetToken(LangParserSTR, 0)
}

func (s *LiteralContext) CHR() antlr.TerminalNode {
	return s.GetToken(LangParserCHR, 0)
}

func (s *LiteralContext) ArrayLiteral() IArrayLiteralContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IArrayLiteralContext)(nil)).Elem(), 0)

	if t == nil {
		return nil
	}

	return t.(IArrayLiteralContext)
}

func (s *LiteralContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *LiteralContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *LiteralContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterLiteral(s)
	}
}

func (s *LiteralContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitLiteral(s)
	}
}

func (p *LangParser) Literal() (localctx ILiteralContext) {
	localctx = NewLiteralContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 26, LangParserRULE_literal)

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	p.SetState(250)
	p.GetErrorHandler().Sync(p)

	switch p.GetTokenStream().LA(1) {
	case LangParserNUM:
		p.EnterOuterAlt(localctx, 1)
		{
			p.SetState(246)
			p.Match(LangParserNUM)
		}

	case LangParserSTR:
		p.EnterOuterAlt(localctx, 2)
		{
			p.SetState(247)
			p.Match(LangParserSTR)
		}

	case LangParserCHR:
		p.EnterOuterAlt(localctx, 3)
		{
			p.SetState(248)
			p.Match(LangParserCHR)
		}

	case LangParserT__2:
		p.EnterOuterAlt(localctx, 4)
		{
			p.SetState(249)
			p.ArrayLiteral()
		}

	default:
		panic(antlr.NewNoViableAltException(p, nil, nil, nil, nil, nil))
	}

	return localctx
}

// IArrayLiteralContext is an interface to support dynamic dispatch.
type IArrayLiteralContext interface {
	antlr.ParserRuleContext

	// GetParser returns the parser.
	GetParser() antlr.Parser

	// IsArrayLiteralContext differentiates from other interfaces.
	IsArrayLiteralContext()
}

type ArrayLiteralContext struct {
	*antlr.BaseParserRuleContext
	parser antlr.Parser
}

func NewEmptyArrayLiteralContext() *ArrayLiteralContext {
	var p = new(ArrayLiteralContext)
	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(nil, -1)
	p.RuleIndex = LangParserRULE_arrayLiteral
	return p
}

func (*ArrayLiteralContext) IsArrayLiteralContext() {}

func NewArrayLiteralContext(parser antlr.Parser, parent antlr.ParserRuleContext, invokingState int) *ArrayLiteralContext {
	var p = new(ArrayLiteralContext)

	p.BaseParserRuleContext = antlr.NewBaseParserRuleContext(parent, invokingState)

	p.parser = parser
	p.RuleIndex = LangParserRULE_arrayLiteral

	return p
}

func (s *ArrayLiteralContext) GetParser() antlr.Parser { return s.parser }

func (s *ArrayLiteralContext) AllExpr() []IExprContext {
	var ts = s.GetTypedRuleContexts(reflect.TypeOf((*IExprContext)(nil)).Elem())
	var tst = make([]IExprContext, len(ts))

	for i, t := range ts {
		if t != nil {
			tst[i] = t.(IExprContext)
		}
	}

	return tst
}

func (s *ArrayLiteralContext) Expr(i int) IExprContext {
	var t = s.GetTypedRuleContext(reflect.TypeOf((*IExprContext)(nil)).Elem(), i)

	if t == nil {
		return nil
	}

	return t.(IExprContext)
}

func (s *ArrayLiteralContext) GetRuleContext() antlr.RuleContext {
	return s
}

func (s *ArrayLiteralContext) ToStringTree(ruleNames []string, recog antlr.Recognizer) string {
	return antlr.TreesStringTree(s, ruleNames, recog)
}

func (s *ArrayLiteralContext) EnterRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.EnterArrayLiteral(s)
	}
}

func (s *ArrayLiteralContext) ExitRule(listener antlr.ParseTreeListener) {
	if listenerT, ok := listener.(LangListener); ok {
		listenerT.ExitArrayLiteral(s)
	}
}

func (p *LangParser) ArrayLiteral() (localctx IArrayLiteralContext) {
	localctx = NewArrayLiteralContext(p, p.GetParserRuleContext(), p.GetState())
	p.EnterRule(localctx, 28, LangParserRULE_arrayLiteral)
	var _la int

	defer func() {
		p.ExitRule()
	}()

	defer func() {
		if err := recover(); err != nil {
			if v, ok := err.(antlr.RecognitionException); ok {
				localctx.SetException(v)
				p.GetErrorHandler().ReportError(p, v)
				p.GetErrorHandler().Recover(p, v)
			} else {
				panic(err)
			}
		}
	}()

	var _alt int

	p.EnterOuterAlt(localctx, 1)
	{
		p.SetState(252)
		p.Match(LangParserT__2)
	}
	p.SetState(258)
	p.GetErrorHandler().Sync(p)
	_alt = p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 18, p.GetParserRuleContext())

	for _alt != 2 && _alt != antlr.ATNInvalidAltNumber {
		if _alt == 1 {
			{
				p.SetState(253)
				p.expr(0)
			}
			{
				p.SetState(254)
				p.Match(LangParserT__6)
			}

		}
		p.SetState(260)
		p.GetErrorHandler().Sync(p)
		_alt = p.GetInterpreter().AdaptivePredict(p.GetTokenStream(), 18, p.GetParserRuleContext())
	}
	p.SetState(262)
	p.GetErrorHandler().Sync(p)
	_la = p.GetTokenStream().LA(1)

	if (((_la)&-(0x1f+1)) == 0 && ((1<<uint(_la))&((1<<LangParserT__0)|(1<<LangParserT__2)|(1<<LangParserT__5)|(1<<LangParserT__7)|(1<<LangParserT__9)|(1<<LangParserT__10)|(1<<LangParserOP_INC)|(1<<LangParserOP_DEC)|(1<<LangParserOP_LNOT)|(1<<LangParserOP_BNOT))) != 0) || (((_la-46)&-(0x1f+1)) == 0 && ((1<<uint((_la-46)))&((1<<(LangParserOP_ADD-46))|(1<<(LangParserOP_SUB-46))|(1<<(LangParserNUM-46))|(1<<(LangParserID-46))|(1<<(LangParserSTR-46))|(1<<(LangParserCHR-46)))) != 0) {
		{
			p.SetState(261)
			p.expr(0)
		}

	}
	{
		p.SetState(264)
		p.Match(LangParserT__3)
	}

	return localctx
}

func (p *LangParser) Sempred(localctx antlr.RuleContext, ruleIndex, predIndex int) bool {
	switch ruleIndex {
	case 1:
		var t *ExprContext = nil
		if localctx != nil {
			t = localctx.(*ExprContext)
		}
		return p.Expr_Sempred(t, predIndex)

	default:
		panic("No predicate with index: " + fmt.Sprint(ruleIndex))
	}
}

func (p *LangParser) Expr_Sempred(localctx antlr.RuleContext, predIndex int) bool {
	switch predIndex {
	case 0:
		return p.Precpred(p.GetParserRuleContext(), 21)

	case 1:
		return p.Precpred(p.GetParserRuleContext(), 15)

	case 2:
		return p.Precpred(p.GetParserRuleContext(), 14)

	case 3:
		return p.Precpred(p.GetParserRuleContext(), 13)

	case 4:
		return p.Precpred(p.GetParserRuleContext(), 12)

	case 5:
		return p.Precpred(p.GetParserRuleContext(), 11)

	case 6:
		return p.Precpred(p.GetParserRuleContext(), 10)

	case 7:
		return p.Precpred(p.GetParserRuleContext(), 9)

	case 8:
		return p.Precpred(p.GetParserRuleContext(), 8)

	case 9:
		return p.Precpred(p.GetParserRuleContext(), 7)

	case 10:
		return p.Precpred(p.GetParserRuleContext(), 6)

	case 11:
		return p.Precpred(p.GetParserRuleContext(), 5)

	case 12:
		return p.Precpred(p.GetParserRuleContext(), 4)

	case 13:
		return p.Precpred(p.GetParserRuleContext(), 23)

	case 14:
		return p.Precpred(p.GetParserRuleContext(), 22)

	case 15:
		return p.Precpred(p.GetParserRuleContext(), 20)

	default:
		panic("No predicate with index: " + fmt.Sprint(predIndex))
	}
}
